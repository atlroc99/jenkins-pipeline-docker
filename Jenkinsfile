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
            sh "${MAVEN_HOME}/bin/mvn clean package"
         }
         stage('END') {
                 sh 'echo "Ending ..."'
         }
}