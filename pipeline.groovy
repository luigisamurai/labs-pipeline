#!/usr/bin/env groovy
import hudson.model.ParameterValue;
import hudson.model.ParametersAction;
// import hudson.model.ParameterDefinition

// @Field final String TEST_ENV_PARAMETER = 'PIPELINE_ENV'

def execute() {
    // def jenkinsfileParameters = currentBuild.rawBuild.getAction(ParameterDefinition.class)
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

    
    parameters {
        booleanParam(defaultValue: true, description: '', name: 'userFlag')
    }

  stage('test') {
    echo('Hello, it is my firts multi branch pipeline.')
    stageDefinition.executeStage()
  }
}

return this
