node{
         stage('Start') {
            sh 'echo "starting ..."'
         }
         stage ('scm checkout git project') {
            git 'https://github.com/atlroc99/jenkins-pipeline-docker.git'
         }
         stage ('maven compile project') {
            //using as variable in the mvn build command
            def MAVEN_HOME = tool name: 'jenkins-maven', type: 'maven'
            sh "${MAVEN_HOME}/bin/mvn clean package -DskipTests=true"
         }
         stage ('run docker container') {
//           docker run -d --name container_name image_name
             sh 'docker run -d -p 8090:8090 --name demo-service demo:latest'
         }
         stage('END') {
                 sh 'echo "Ending ..."'
         }
}