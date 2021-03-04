# <div align = center><h1>bmrec</h1></div>
A fast and easy to use screen recording software,based on FFmpeg.

Table of Contents
=================

* [About](#about)
* [LICENSE](#license)
* [Requirements](#requirements)
* [Download](#download)
* [How to install](#how-to-install)
    * [Portable use](#portable-use)
    * [Permission denied](#permission-denied)
* [Issues](#issues)
* [Attribution](#attribution)

# About
bmrec is a front-end for FFmpeg,which is a program designed for command-line-based processing of video and audio files.bmrec's GUI is straightforward and easy to navigate.
Here is the main menu :

<img src="https://raw.githubusercontent.com/datcuandrei/bmrec/master/captures/main.png" width=50% height=50% />

*also has dark mode*

<img src="https://raw.githubusercontent.com/datcuandrei/bmrec/master/captures/maindark.png" width=50% height=50% />

# LICENSE

This project is licensed under the GNU GPLv3 license. View LICENSE.md to learn more.

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



# Issues

If you find issues while running the app,please report them in the [issues](https://github.com/datcuandrei/bmrec/issues) section.


# Attribution

- bmrec's UI would have not been possible without [FlatLaf](https://www.formdev.com/flatlaf/) library.
- bmrec is based on [FFmpeg](https://www.ffmpeg.org/).
- Special thanks to the [Unsupported Macs](https://discord.gg/XbbWAsE) community.
