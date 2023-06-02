# variables
export GRADLE_PATH=./version.properties
export GRADLE_FIELD="versionName"
# logic
export VERSION_TMP=$(grep $GRADLE_FIELD $GRADLE_PATH | cat $2)
export VERSION=$(echo $VERSION_TMP | sed -e 's/^versionName=//'  -e 's/"$//')
# result
echo release tag: $VERSION
# release
git add .
git commit -m "new release"
git push
git tag "$VERSION"
git push origin "$VERSION"