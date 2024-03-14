# DOCSONA REMODEL

### README UPDATE IN PROGRESS

## HOW TO RUN

### CODIO

If you are in my AP CSA class and have access to Codio projects, you can run pull this repository and run it there.

1. Go to create a new project in the "My Projects" tab under building.

2. On the create tab for the project, select "Import."

3. Change the stack to Java 11, and the source to Git. For URL, click the green code button on this page, and copy that URL into Codio.

4. Create the project with whatever name you'd like.

5. Select "Java.main" and then "Configure" in the top-middle of the screen.

6. If Codio opens a file that prompts you to configure compile and run, paste the following code:

```
{
  // Configure your Run and Preview buttons here.
  
  // Run button configuration
      "commands": {
          "Compile & Run": "cd docsona-remodel; javac Main.java && java Main",
          "Compile": "cd docsona-remodel; javac {{filename}}",
          "Run": "java {{filename_no_ext}}"
      },
  
  // Preview button configuration
    "preview": {
          "Project Index (static)": "https://{{domain}}/{{index}}",
          "Current File (static)": "https://{{domain}}/{{filepath}}",
          "Box URL": "https://{{domain3000}}/"
    }
  }
```

7. Resize the terminal window to be as large as possible.

### COMPUTER WITH JAVA INSTALLED

If you do not have access to Codio, you can download the jar from releases and run it in any terminal/command prompt.

1. Download the latest version of Java SE from Oracle's website for your respective platform (these instructions were tested with ARM64 DMG for M-series MacBooks)

2. Navigate to the "Releases" tab on the repo page, located to the right of the code on desktop.

3. Download the jar file, and open a terminal/command prompt window.

4. Make the window as large as possible.

5. Type "Java -jar " and then drag-and-drop the .jar file into the window.
