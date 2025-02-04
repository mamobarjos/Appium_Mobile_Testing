## Overview
This document explains the step-by-step setup for Appium Mobile Automation for Android. It covers everything from installing Java and Android Studio to configuring environment variables, setting up an emulator, and installing Appium.

## Setup Instructions

1. **Download and Install Java**
   - Download Java from the official website.
   - Set the `JAVA_HOME` environment variable to point to your Java installation directory.

2. **Download Android Studio**
   - Download Android Studio from [this link](https://developer.android.com/studio#downloads).
   - The downloaded `.exe` file contains both the SDK and Android Studio.

3. **Locate Android Installation Path**
   - Check the Android installation directory by navigating to:  
     `C:\Users\<Your_System_Name>\AppData\Local\Android\`
   - Look for the `sdk` folder within the Android directory.

4. **Set the ANDROID_HOME Environment Variable**
   - Open the `sdk` folder and copy its path.
   - Go to **Advanced System Settings** > **Advanced** > **Environment Variables**.
   - Click **New** and create a variable named `ANDROID_HOME` with the copied SDK path as its value.
   - Next, navigate into the `tools\bin` folder inside the SDK, copy that path, and add it to the system `Path` along with:
     - `C:\Users\<Your_System_Name>\AppData\Local\Android\Sdk\tools`
     - `C:\Users\<Your_System_Name>\AppData\Local\Android\Sdk\platform-tools`

5. **Configure the Android Virtual Device (Emulator)**
   - Open Android Studio from:  
     `C:\Program Files\Android\Android Studio\bin`
   - Choose **Import Android Code Sample**, then select any sample project and proceed until you reach the home window.
   - From the **Tools** menu, select **Device Manager** (or search for **AVD Manager**).
   - Click **+Create Virtual Device**, select a device (e.g., Pixel 3), then click **Next**.
   - Select an Android version (ensure you download the release first, e.g., Pie) and complete the download.
   - In the advanced settings, provide a name for your AVD (e.g., Demo) and click **Finish**.
   - Launch the virtual device by clicking **Launch**.

6. **Verify Emulator Operation**
   - Open the Command Prompt and navigate to the platform-tools directory:
     ```bash
     cd C:\Users\<Your_System_Name>\AppData\Local\Android\Sdk\platform-tools
     ```
   - Run the emulator by typing:
     ```bash
     emulator -avd <AVD_Emulator_Name>
     ```
     For example:
     ```bash
     emulator -avd Demo
     ```

7. **Download and Install Node.js**
   - Download Node.js from [this link](https://nodejs.org/en/download/).
   - Choose the appropriate installer (e.g., 64-bit) and complete the installation.

8. **Set the NODE_HOME Environment Variable**
   - After installation, navigate to `C:\Program Files\nodejs` and copy the path.
   - Create a new environment variable named `NODE_HOME` with this path as its value.

9. **Set npm Environment Variable**
   - Navigate to `C:\Program Files\nodejs\node_modules\npm\bin` and copy the path.
   - Add this path to the system `Path` environment variable.

10. **Install Appium Server Using npm**
    - Open the Command Prompt and run:
      ```bash
      npm install -g appium
      ```
    - After installation, verify it by typing:
      ```bash
      appium
      ```
      You should see a welcome message similar to:
      ```
      Welcome to Appium v2...
      Appium REST http interface Listener started on 0.0.0.0:4723
      ```
    - **Notes:**
      - **Client:** Appium allows you to write tests in various languages (Java, JavaScript, C#, Python, Ruby, etc.) using specific client libraries (e.g., Appium Java client jar).
      - **Server:** The Appium Server listens to commands from the client and executes them on your device or emulator.
      - To uninstall Appium, run:
        ```bash
        npm uninstall -g appium
        ```
      - An Appium Desktop installer is also available at:  
        [Appium Desktop Releases](https://github.com/appium/appium-desktop/releases/tag/v1.13.0)
      - To download APK files, visit:  
        [Download Apk files](https://apkpure.com/)

11. **Set Up Your Development Environment**
    - Install and open Eclipse.
    - Create a Maven Project (using the QuickStart template) and add the necessary Appium client dependencies.

12. **Configure Desired Capabilities**
    - Set the desired capabilities in your Appium setup to match your target device and application settings.

13. **Run Your Appium Test**
    - Execute your base/setup Appium program to launch and test the Android application.

## YouTube Playlist
For a detailed video explanation of the entire setup process, check out this YouTube playlist:  
[Appium Mobile Automation Setup Playlist](https://youtube.com/playlist?list=PLN9RL2PyZc19aq95VjhXzeUmuU4-6N6Qf&si=tAXqttCpw_TwsgfV)

---

This README provides a comprehensive guide to setting up your environment for Appium Mobile Automation on Android. 

