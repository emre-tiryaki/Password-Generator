**Password Generator**

This is a Java GUI application that generates secure random passwords. Users can specify the password length and choose to include uppercase letters, lowercase letters, numbers, and special characters.

**Features**

* Generates random passwords of a specified length
* Includes options for uppercase letters, lowercase letters, numbers, and special characters
* Displays the generated password in a text field
* Allows users to copy the generated password to the clipboard

**Getting Started**

1. Clone this repository to your local machine.
2. Ensure you have Java installed and configured on your system.
3. Open the project in an IDE that supports Java, such as Eclipse or IntelliJ IDEA.
4. Run the `Main` class to start the application.

**How it Works**

The application uses the following classes:

* `Generation`: This class handles generating random passwords. It takes booleans as input to specify whether to include uppercase letters, lowercase letters, numbers, and special characters in the password.
* `MainFrame`: This class is the main graphical user interface (GUI) for the application. It contains panels for displaying the options, generating the password, and displaying the result.
* `Constants`: This class stores constants used throughout the application, such as the default frame size and icons.
* `MyButton`: This is a custom button class that creates buttons with a rounded border and a specific background color.
* `MyFrame`: This is a custom frame class that sets the default properties for the application window.
* `MyTextField`: This is a custom text field class that includes a label for the text field.
* `TextFieldKeyListener`: This class is a key listener that restricts the input in the password size text field to only digits and the delete key.

**Resources**

The resources folder contains the following files:

* `password.png`: This image is used as the application icon.
* `copy.png`: This image is used on the copy button.
