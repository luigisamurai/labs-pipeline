#!/usr/bin/env groovy
import hudson.model.ParameterValue;
import hudson.model.ParametersAction;
// import hudson.model.ParameterDefinition

// @Field final String TEST_ENV_PARAMETER = 'PIPELINE_ENV'

def execute() {
    // def jenkinsfileParameters = currentBuild.rawBuild.getAction(ParametersAction.class)
    // def jenkinsbuilds = currentBuild.rawBuild.getAction(BuildDiscarder.class)

    // def jenkinsfileParameters = currentBuild.rawBuild.getAction(ParametersAction.class)
    // def allParameters = []

    // def pipelineParameter =  string(
    //     name: TEST_ENV_PARAMETER,
    //     description: 'Pipeline Environment Config key',
    //     defaultValue: env.DEFAULT_PIPELINE_ENV
    // )

    // allParameters.add(pipelineParameter)

    // for(ParameterValue parameter in jenkinsfileParameters) {
    //     println parameter.name
    //     println parameter.getDefinition().getType()
    //     def item

    //     if (parameter.choices) {
    //         item = choice(
    //             name: parameter.name,
    //             description: description: parameter.description,
    //             choices: parameter.choices,
    //             defaultValue: parameter.defaultValue
    //         )
    //     } else if () {

    //     } else {
    //         item = string(
    //             name: parameter.name,
    //             description: parameter.description,
    //             defaultValue: parameter.defaultValue
    //         )
    //     }
    //     allParameters.add(item)
    // }

    // properties([
    //     buildDiscarder(
    //         logRotator(artifactDaysToKeepStr: '', 
    //                 artifactNumToKeepStr: '', 
    //                 daysToKeepStr: env.DISCARD_DAYS, 
    //                 numToKeepStr: env.DISCARD_NUMBER_BUILDS)),
    //     parameters(allParameters)
    // ])

    // properties([
    //     buildDiscarder(jenkinsbuilds),
    //     parameters(jenkinsfileParameters)
    // ])

  def changeLogSets = currentBuild.changeSets
  for (int i = 0; i < changeLogSets.size(); i++) {
      def entries = changeLogSets[i].items
      for (int j = 0; j < entries.length; j++) {
          def entry = entries[j]
          echo "${entry.commitId} by ${entry.author} on ${new Date(entry.timestamp)}: ${entry.msg}"
          def files = new ArrayList(entry.affectedFiles)
          for (int k = 0; k < files.size(); k++) {
              def file = files[k]
              echo "  ${file.editType.name} ${file.path}"
          }
      }
  }

  stage('test') {
    echo('Hello, it is my firts multi branch pipeline.')
  }
}

return this
