#!/bin/bash
# todo this will be improved, incubating
###
RN_FILE="release-notes.txt"
APP_VERSION=$1
GIT_BRANCH=$2
echo "# Release Notes for $APP_VERSION version:\n" >> $RN_FILE
###
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
        echo $temp | awk '{$1="";$2="";print}' >> $RN_FILE
    else
        echo >> $RN_FILE
        DATE=$NEWDATE
        echo `date --date=$DATE +%d-%B-%Y` >> $RN_FILE
        echo $temp | awk '{$1="";$2="";print}' >> $RN_FILE
    fi
fi
done
echo "Crating release notes from commits done."
echo "File content:"
cat $RN_FILE