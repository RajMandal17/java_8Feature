const vscode = require('vscode');

function activate(context) {
    let disposable = vscode.commands.registerCommand('extension.toggleAutocomplete', async function () {
        const editorConfig = vscode.workspace.getConfiguration('editor');
        const copilotConfig = vscode.workspace.getConfiguration('github.copilot.enable');
        
        // Get current state of quickSuggestions
        const currentState = editorConfig.get('quickSuggestions');
        
        // Determine new state (toggle)
        let newState;
        let isEnabled;
        
        if (currentState === false || currentState === 'off') {
            // Enable autocomplete
            newState = {
                "other": true,
                "comments": false,
                "strings": false
            };
            isEnabled = true;
        } else {
            // Disable autocomplete
            newState = false;
            isEnabled = false;
        }

        // Update all autocomplete settings globally
        await Promise.all([
            // Standard autocomplete
            editorConfig.update('quickSuggestions', newState, vscode.ConfigurationTarget.Global),
            editorConfig.update('suggestOnTriggerCharacters', isEnabled, vscode.ConfigurationTarget.Global),
            editorConfig.update('acceptSuggestionOnEnter', isEnabled ? 'on' : 'off', vscode.ConfigurationTarget.Global),
            editorConfig.update('wordBasedSuggestions', isEnabled ? 'matchingDocuments' : 'off', vscode.ConfigurationTarget.Global),
            
            // GitHub Copilot
            vscode.workspace.getConfiguration().update('github.copilot.enable', 
                { '*': isEnabled }, 
                vscode.ConfigurationTarget.Global
            ),
            
            // IntelliSense
            editorConfig.update('parameterHints.enabled', isEnabled, vscode.ConfigurationTarget.Global),
            editorConfig.update('suggest.snippetsPreventQuickSuggestions', !isEnabled, vscode.ConfigurationTarget.Global)
        ]);
        
        // Show notification
        vscode.window.showInformationMessage(
            `${isEnabled ? '✅ ENABLED' : '❌ DISABLED'}: Autocomplete + Copilot + IntelliSense`
        );
    });

    context.subscriptions.push(disposable);
    
    // Show message on activation
    console.log('Toggle Autocomplete extension is now active! Press Ctrl+Alt+I to toggle.');
}

function deactivate() {}

module.exports = {
    activate,
    deactivate
}