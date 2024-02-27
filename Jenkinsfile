// 

pipeline {
    agent any
    stages {
        stage('Build and Test') {
            steps {
                // Compilation
                sh 'mvn compile'
                // Exécution des tests
                sh 'mvn test'
            }
        }
        stage('Modify Test to Fail') {
            steps {
                // Modifier un test pour le faire échouer
                // Par exemple, en changeant une valeur attendue
                // ou en introduisant une assertion incorrecte
            }
        }
        stage('Verify Compilation and Test Failure') {
            steps {
                // Vérification que la compilation fonctionne
                // même si le test échoue
                sh 'mvn compile'
                // Exécuter les tests et ignorer les résultats
                script {
                    try {
                        sh 'mvn test'
                    } catch (err) {
                        // Le test doit échouer
                        echo "Test failed as expected"
                    }
                }
            }
        }
        stage('Ignore Test via Maven') {
            steps {
                // Ignorer le test via Maven
                sh 'mvn -Dmaven.test.skip=true test'
            }
        }
        stage('Publish Test Report') {
            steps {
                // Publier le rapport de tests
                // Selon le plugin utilisé (JUnit, TestNG, etc.),
                // vous devez configurer Jenkins pour collecter
                // et afficher les rapports de tests.
                // Cela peut varier en fonction de la configuration de votre projet.
            }
        }
    }
}
