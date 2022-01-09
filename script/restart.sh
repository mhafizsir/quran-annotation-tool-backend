mkdir -p logs
#git fetch
#git pull
mvn clean install -DskipTests
kill -9 $(lsof -i :9010 -sTCP:LISTEN |awk 'NR > 1 {print $2}')
nohup java -jar ./target/*.jar >> logs/out.log 2>&1 &
tail -f logs/out.log
