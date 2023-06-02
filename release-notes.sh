#!/bin/bash
DATE=
git log --pretty=format:"%ad || %h || %s || Author:%an " --date=short | sort -r | while read line
do
temp=`echo $line | egrep -v '(Automatic merge from|Merge pull request|Merge conflict from|Resolve Conflict From)'`
if [ "$temp" = "" ]
then
    continue
else
    NEWDATE=`echo $temp |  awk  '{print $1}'`
    if [ "$NEWDATE" = "$DATE" ]
    then
        echo $temp | awk '{$1="";$2="";print}' >> release-notes.txt
    else
        echo >> releaseNotes.txt
        DATE=$NEWDATE
        echo `date --date=$DATE +%d-%B-%Y` >> release-notes.txt
        echo $temp | awk '{$1="";$2="";print}' >> release-notes.txt
    fi
fi
done