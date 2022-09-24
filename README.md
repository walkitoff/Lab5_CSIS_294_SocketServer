# Lab5_CSIS_294_SocketServer
Lab 5 – Socket programming only

NOTE:  For this lab, you will get 5 points for a valid attempt if turned in by the due date.

The main new functionality in this lab was reviewed in class.

1.	SUMMARY

a.	Adjust the code we did in class to pass a comma delimited string to the server you’re connected to that includes three numbers to add together separated by commas. 

b.	This lab will involve the following new features:
i.	Socket network programming

2.	DETAILS

a.	These instructions will be more bare than usual since the source code from class can be used towards this.  Only the new parts to the code are mentioned.

b.	SocketManager
i.	Ask all the following of the user:
1.	A port to run its server on (something like 8800 or 8888)
2.	An IP of another server (local computer is 127.0.0.1)
a.	NOTE: If running on two computers, to get the IP address of a computer, in a command prompt or powershell, simply type “ipconfig” and look for the IPV4 address or IPV6 – whichever comes first.  It will probably look something like this: 192.168.0.3
3.	The port of that other server.
ii.	After starting up the server, it should enter a never-ending loop that does the following:
1.	Asks the user for three numbers separated by commas.  So the user would enter something  like this:
4,7,22
2.	Sends that raw text to the server using the SocketClient class as we did in class.
a.	IMPORTANT: The items sent should be comma-delimited all concatenated as one string.

c.	SocketServer
i.	When the server receives a message from a client, it should try to parse the comma-delimited message into an array.
1.	HINT: Use the sReceivedMessage.split(",") to get a String array of the comma-delimited items.
ii.	Then turn each array string into three int variables.
1.	Use Integer.parseInt() to do this on each item in the array.
2.	Then sum these numbers into a result.

iii.	Reply with the sum of these numbers.

d.	SocketClient
i.	This is the same as we did in class.




e.	TESTING YOUR CODE with two instances of your app.
i.	Simply look at the “Testing Your Code” section in the Project 1 document.  This specifies what we did in class with the Jar file and running command line or Power Shell to run your app. 
ii.	IMPORTANT NOTE: if error says java command not recognized, see jar instructions file in canvas project 1 module, and in the “---RUNNING JAR FILE ---” section at the bottom, it will explain how to fix that in Windows computer.

3.	TURNING IN LAB: 

a.	Turn your lab into Canvas.
b.	IMPORTANT: DO NOT ZIP your folders/files please.  
c.	Turn in ALL the java files for this lab.
