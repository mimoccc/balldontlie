#!/bin/bash
# todo this will be improved, incubating
DATE=
# shellcheck disable=SC2162
git log --pretty=format:"%ad || %h || %s || Author:%an " --date=short | sort -r | while read line
do
# shellcheck disable=SC2006
# shellcheck disable=SC2086
# shellcheck disable=SC2196
temp=`echo $line | egrep -v '(Automatic merge from|Merge pull request|Merge conflict from|Resolve Conflict From)'`
if [ "$temp" = "" ]
then
    continue
else
    # shellcheck disable=SC2006
    # shellcheck disable=SC2086
    NEWDATE=`echo $temp |  awk  '{print $1}'`
    if [ "$NEWDATE" = "$DATE" ]
    then
        # shellcheck disable=SC2086
        echo $temp | awk '{$1="";$2="";print}' >> release-notes.txt
    else
        echo >> releaseNotes.txt
        DATE=$NEWDATE
        # shellcheck disable=SC2046
        # shellcheck disable=SC2006
        # shellcheck disable=SC2005
        # shellcheck disable=SC2086
        echo `date --date=$DATE +%d-%B-%Y` >> release-notes.txt
        # shellcheck disable=SC2086
        echo $temp | awk '{$1="";$2="";print}' >> release-notes.txt
    fi
fi
done