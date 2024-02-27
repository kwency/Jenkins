pipeline {
    agent any // Utiliser n'importe quel agent disponible
    
    tools {
        // Assurez-vous que "Maven_3_5_2" correspond au nom que vous avez donné à l'installation de Maven dans la configuration globale de Jenkins
        maven 'maven-3.5.2'
    }
    
    triggers {
        pollSCM('H/3 * * * *') // Vérifier les changements du SCM toutes les 3 minutes
    }
    
    options {
        skipStagesAfterUnstable() // Pour ne pas continuer après un échec de compilation
    }

    stages {
        stage('Récupération du code source') {
            steps {
                checkout scm // Cette commande clone le dépôt et vérifie la branche correcte
            }
        }
        
        stage('Compilation') {
            steps {
                script {
                    // Compile le projet sans exécuter les tests
                    sh 'mvn clean compile -DskipTests'
                }
            }
        }

        stage('Compilation tests') {
            steps {
                script {
                    // Compile le projet et exécute les tests
                    sh 'mvn clean test'
                }
            }
        }

        
        stage('Publication de la Javadoc') {
            steps {
                script {
                    // Génère la Javadoc
                    sh 'mvn -f pom.xml javadoc:javadoc'
                    
                    // Archive la Javadoc en tant qu'artefact
                    archiveArtifacts artifacts: '**/target/apidocs/**/*', fingerprint: true
                }
            }
        }
    }
    
    post {
        always {
            // Archiver les artefacts même en cas d'échec
            archiveArtifacts artifacts: '**', fingerprint: true
        }
    }
}