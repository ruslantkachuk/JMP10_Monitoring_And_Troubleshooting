Monitoring and troubleshooting
-----------------------

#### Deadlock
The simplest way to create a deadlock is to call the join method of the thread on itself:
    Thread.currentThread().join();
    
To find the deadlock, you can use the program visualVM. As a result, after receiving the dump, you can see the following: 

    "main" #1 prio=5 os_prio=31 tid=0x00007fb18a801800 nid=0x1b03 in Object.wait() [0x000070000f194000]
    java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x00000006c02e7cb0> (a java.lang.Thread)
	at java.lang.Thread.join(Thread.java:1245)
	- locked <0x00000006c02e7cb0> (a java.lang.Thread)
	at java.lang.Thread.join(Thread.java:1319)
	at com.jmp.JmpApplication.main(JmpApplication.java:11)

    Locked ownable synchronizers:
	- None

As you can see:

	- waiting on <0x00000006c02e7cb0> (a java.lang.Thread)
	- locked <0x00000006c02e7cb0> (a java.lang.Thread)
	
with the same id 0x00000006c02e7cb0, it's mean that thread locked by itself
