# variables
export GRADLE_PATH=./version.properties
export GRADLE_FIELD="versionName"
# logic
export VERSION_TMP=$(grep $GRADLE_FIELD $GRADLE_PATH | cat $2)
export VERSION=$(echo $VERSION_TMP | sed -e 's/^versionName=//'  -e 's/"$//')
# gh install
#type -p curl >/dev/null || (sudo apt update && sudo apt install curl -y)
#curl -fsSL https://cli.github.com/packages/githubcli-archive-keyring.gpg | sudo dd of=/usr/share/keyrings/githubcli-archive-keyring.gpg \
#&& sudo chmod go+r /usr/share/keyrings/githubcli-archive-keyring.gpg \
#&& echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/githubcli-archive-keyring.gpg] https://cli.github.com/packages stable main" | sudo tee /etc/apt/sources.list.d/github-cli.list > /dev/null \
#&& sudo apt update \
#&& sudo apt install gh -y
# result
echo release tag: $VERSION
# release
git add .
git commit -m "new release"
git push
git tag "$VERSION"
#git push origin "$VERSION"