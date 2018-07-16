#!/bin/bash

CLASSPATH=.:/home/project/oracle/OraHome1/jre/1.1.8
CLASSPATH=$CLASSPATH:/home/project/oracle/OraHome1/jlib
CLASSPATH=$CLASSPATH:/home/project/oracle/OraHome1/jdbc/lib/classes12.zip
CLASSPATH=$CLASSPATH:/home/project/oracle/OraHome1/jdbc/lib/nls_charset12.zip
CLASSPATH=$CLASSPATH:/home/project/oracle/OraHome1/sqlj/lib/runtime.zip
CLASSPATH=$CLASSPATH:/home/project/oracle/OraHome1/sqlj/lib/translator.zip
CLASSPATH=$CLASSPATH:/home/project/oracle/OraHome1/ord/jlib
CLASSPATH=$CLASSPATH:/home/project/oracle/OraHome1/ord/ts/jlib
CLASSPATH=$CLASSPATH:/home/project/oracle/OraHome1/rdbms/jlib
CLASSPATH=$CLASSPATH:/usr/j2se/bin

export CLASSPATH
export ORACLE_SID=orcl
export ORACLE_HOME=/home/project/oracle/OraHome1
export DBPASS=database
export PATH=${PATH}:/home:/usr/bin:/usr/java/bin:/usr/java/sdk/bin
perl InsertCD.pl
