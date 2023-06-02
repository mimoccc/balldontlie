#!/bin/bash
# todo this will be improved, incubating
echo "Crating release notes from commits."
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
        echo >> release-notes.txt
        DATE=$NEWDATE
        echo `date --date=$DATE +%d-%B-%Y` >> release-notes.txt
        echo $temp | awk '{$1="";$2="";print}' >> release-notes.txt
    fi
fi
done
echo "Copying to wikis"
# todo
echo "Crating release notes from commits done."