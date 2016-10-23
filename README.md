# Poolbot Android App

A mobile app developed for android devices, which pulls and displays data from the Poolbot Server.

## Custom Configuration

The server URL should be added to a `server.xml` file in the `resources` package. This is ignored by git, but the 
HTTP client expects a value to exist. You should add something like this:

```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="server_url">https://my-poolbot-server.com/api/</string>
</resources>
```
