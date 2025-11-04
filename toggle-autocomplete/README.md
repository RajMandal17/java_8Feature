# Toggle Autocomplete Extension

## 🎯 Purpose
Quickly toggle VS Code autocomplete/IntelliSense ON/OFF with a keyboard shortcut.

## ⌨️ Keyboard Shortcut
- **Windows/Linux**: `Ctrl + Alt + I`
- **Mac**: `Cmd + Alt + I`

## 📦 Installation

### Method 1: Install from VSIX (Recommended)
```bash
cd /workspaces/java_8Feature/toggle-autocomplete
vsce package
code --install-extension toggle-autocomplete-1.0.0.vsix
```

### Method 2: Install from folder
```bash
code --install-extension /workspaces/java_8Feature/toggle-autocomplete
```

### Method 3: Copy to extensions folder
```bash
cp -r /workspaces/java_8Feature/toggle-autocomplete ~/.vscode-server/extensions/
```

## 🚀 Usage
1. Press `Ctrl + Alt + I` to toggle autocomplete
2. You'll see a notification: "✅ Autocomplete ENABLED" or "✅ Autocomplete DISABLED"
3. Works globally across all projects!

## ✅ Features
- Global toggle (works in all projects)
- Keyboard shortcut: `Ctrl+Alt+I`
- Visual notification on toggle
- Remembers state across VS Code restarts

## 🛠️ What it toggles
- `editor.quickSuggestions` setting
- Applied globally to all workspaces

## 📝 Notes
- Setting is saved globally, so it persists across all VS Code sessions
- Works in any project, any language
- No need to configure per project
