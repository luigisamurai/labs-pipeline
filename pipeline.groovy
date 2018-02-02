#!/usr/bin/env groovy
import hudson.model.StringParameterValue
import hudson.model.StringParameterDefinition
import hudson.model.ParametersDefinitionProperty
import hudson.model.ParameterDefinition
import hudson.model.ParametersAction
import com.cloudbees.groovy.cps.NonCPS

@NonCPS
def execute() {
  // def newParam = new StringParameterDefinition('foo', 'var', 'mi variable')
  // def newArrList = []
  // newArrList.add(newParam)
  // def newParamDef = new ParameterDefinition(newArrList)

  // echo("=======> el nombre es: ${currentBuild.getProjectName()}")
  // currentBuild.rawBuild.addAction(newParamDef)

  // def pa = new ParametersAction([
  //   new StringParameterValue("FOO", "BAR")
  // ])
  // currentBuild.rawBuild.addAction(pa)


  // def pa = new ParametersAction([
  //   new StringParameterValue("FOO", "BAR")
  // ])
  // currentBuild.getParent().addAction(pa)

  def pipelineParameter =  string(
      name: 'PIPELINE_ENV',
      description: 'Pipeline Environment Config key',
      defaultValue: env.DEFAULT_PIPELINE_ENV
  )

  def allParameters = []
  allParameters.add(pipelineParameter)
  def jenkinsfileParameters = currentBuild.rawBuild.getAction(ParametersAction.class)

  for(ParameterValue parameter in jenkinsfileParameters) {
      def item

      if (parameter.choices) {
          item = choice(
              name: parameter.name,
              description: parameter.description,
              choices: parameter.choices,
              defaultValue: parameter.defaultValue
          )
      } else {
          item = string(
              name: parameter.name,
              description: parameter.description,
              defaultValue: parameter.defaultValue
          )
      }
      allParameters.add(item)
  }

  properties([
    pipelineTriggers(currentBuild.getJob().getTriggers()),
    parameters (allParameters)
  ])

  stage('test') {
    echo("Hello, it is my firts multi branch pipeline. ${env.FOO}")
  }
}

return this
