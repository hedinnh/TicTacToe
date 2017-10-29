![Awesome Software Solutions](https://reykjavikuniversity-my.sharepoint.com/personal/jonb11_ru_is/_layouts/15/guestaccess.aspx?docid=159bd2fb9f9134517a7afa2bd488fdc39&authkey=AVVn2ffzxpv1OSM7aMCfQpE)
----
# What you need to start development

## You need the source code
The source code is kept in a private repository on github.
To gain access to the source code send a request to [ASS].
You will get sent a link that you will use in the next step.

## You need git and a github account

Create an account on [github].
To be able to get the source code you need to have git installed on your computer.
- ###### Install on [Windows]
- ###### Install on [MacOS]
- ###### Install on [GNU/Linux and UNIX]
Clone the code to your computer
```sh
git clone [insert the link you got sent]
```

## You need java

### Install on MacOS or Windows
- Download the jdk installer from [Oracle] Java and run it.
- Add Java to the [Path].

### Install on GNU/Linux
Install `openjdk-8-jdk`
#### Ubuntu and Ubuntu-based systems:
```sh
sudo apt-get install openjdk-8-jdk
```
- Also available as jdk in synaptic package manager.

#### Arch and Arch-bashed systems using yaourt:
```sh
yaourt jdk
```
- Also available as jdk in AUR.

#### Install FreeBSD and BSD systems:
```sh
pkg install openjdk8
```
## You need Gradle
Gradle is used for build automation.
- ###### install [Gradle]

## You need to build

To run the program you need to build it first.
Navigate to the root of the project, TicTacToe.
```sh
gradle build run
```

License
----
MIT
