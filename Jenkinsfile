node {
    stage('Build') {
        echo "Building"
    }
    stage('Deploy') {
        echo "Deploying"
    }
    stage('SCM Checkout') {
         git ''
    }
    stage('Run-Tests') {
         sh 'mvn clean test'
    }
}