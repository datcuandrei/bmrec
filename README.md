# bmrec
A fast and easy to use screen recording software,based on FFmpeg.

# About
bmrec is a front-end for FFmpeg,which is a program designed for command-line-based processing of video and audio files.bmrec's GUI is straightforward and easy to navigate.
Here is the main menu :

<img src="https://raw.githubusercontent.com/datcuandrei/bmrec/master/captures/main.png" width=30% height=30% />

*also has dark mode*

<img src="https://raw.githubusercontent.com/datcuandrei/bmrec/master/captures/maindark.png" width=30% height=30% />

# Requirements

- Latest Java version.



# Download 

- Installing the latest version of Java is as simple as opening the terminal and typing :



##### Debian,Ubuntu-based :

```bash

$ sudo apt-get update

$ sudo apt install default-jdk

```



##### Arch-based :

```bash

$ sudo pacman -S jdk-openjdk

```



##### Fedora, Oracle Linux, Red Hat Enterprise Linux, etc. : 

```bash

$ sudo dnf search openjdk

```

Choose the desired JDK and then install it :



```bash

$ sudo dnf install java-11-openjdk.x86_64

```



- After installing Java,download the latest version available in [releases](https://github.com/datcuandrei/bmrec/releases).

- Extract it where you want the application to be installed.



# How to install

- To install the application,open terminal,``cd path/to/extracted/app``,and then run :

```bash

$ sudo sh setup

```



After the installation is done,simply run `bmrec`,or search for it using an application finder.

If the app doesn't launch,use `sudo java -jar /opt/bmrec.jar` in the terminal instead.



- To uninstall the application,open terminal,``cd path/to/extracted/app``,and then run :

```bash

$ sudo sh uninstall

```

## Portable use

To use bmrec without installing it,after extracting it,open terminal and

```bash

$ cd path/to/extracted/app

$ sudo java -jar bmrec.jar
```

## Permission denied

This error occures when the user does not have enough privileges to access the program.

In this case,we need to get ownership of the app by typing :

```bash
$ chmod +x /bin/bmrec

$ chmod +x /opt/bmrec.jar
```

or if you run bmrec as portable :

```bash

$ cd path/to/extracted/app

$ chmod +x bmrec.jar

```

After that you can run the app using the commands provided above.

