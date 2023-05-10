
mvn clean package -DskipTests

echo 'Copy files...'

scp -i ~/Downloads/horizon.pem \
    ./target/*.jar \
    ubuntu@3.34.2.208:~/horizon/horizon-builder.jar

echo 'Restart the server...'

ssh -i  ~/Downloads/horizon.pem ubuntu@3.34.2.208 << EOF
pgrep java | xargs kill -9
nohup java -jar horizon/horizon-builder.jar &
EOF

echo 'Bye!'