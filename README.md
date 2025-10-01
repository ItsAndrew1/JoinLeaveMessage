# JoinMessage

A simple Minecraft plugin that lets you customize the **join** and **leave** messages on your server.  
Made with the Spigot/Paper API.

---

## ✨ Features
- Customizable **join** and **leave** messages.  
- Supports **color codes** using `&` (e.g. `&a`, `&c`).  
- Placeholder `{player}` for the player’s name.  
- Change messages easily via config or in-game commands.  

---

## ⚙️ Installation
1. Download the latest release from the [Releases page](../../releases).  
2. Drop the `.jar` file into your server’s `plugins/` folder.  
3. Restart your server.  
4. Edit `plugins/JoinMessage/config.yml` to your liking.  

---

## 📖 Configuration
Default `config.yml`:
```yaml
join-message: "&a{player} has joined the server!"
leave-message: "&c{player} has left the server!"
```
{player} → replaced with the player’s username.
& → used for Minecraft color codes.

---

## 🛠️ Development
This plugin is built with the Spigot/Paper API.
Folder structure: 
	src/main/java/me/andrew/joinMessage/JoinMessage.java
	src/main/resources/plugin.yml
	src/main/resources/config.yml
