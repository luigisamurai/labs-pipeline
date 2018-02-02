#!/usr/bin/env groovy
import hudson.model.StringParameterValue
import hudson.model.StringParameterDefinition
import hudson.model.ParametersDefinitionProperty
import hudson.model.ParameterDefinition
import hudson.model.ParametersAction
import com.cloudbees.groovy.cps.NonCPS
import hudson.triggers.Trigger
import hudson.model.JobParameterDefinition

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

  // def pipelineParameter =  string(
  //     name: 'PIPELINE_ENV',
  //     description: 'Pipeline Environment Config key'
  // )

  // def allParameters = []
  // allParameters.add(pipelineParameter)
  // def jenkinsfileParameters = currentBuild.rawBuild.getAction(ParametersAction.class)

  // def jenkinsfileTriggers = currentBuild.rawBuild.getAction(Trigger.class)

  // for(ParameterValue trigger in jenkinsfileTriggers) {
  //   println trigger.Cron
  // }

  // for(ParameterValue parameter in jenkinsfileParameters) {
  //     def item

  //     item = string(
  //         name: parameter.name,
  //         description: parameter.description
  //     )
      
  //     allParameters.add(item)
  // }

  // properties([
  //   pipelineTriggers(jenkinsfileTriggers),
  //   parameters (allParameters)
  // ])

  // this.setProperty('NEW_PROPERTY', 'hello')
  // println this.getProperty('NEW_PROPERTY')

  // userInput = input(
  //   id: 'Proceed1', 
  //   message: 'Was this successful?',
  //   parameters: [
  //     [$class: 'StringParameterDefinition', defaultValue: 'stg', description: '', name: 'Please confirm you agree with this']
  //   ]
  // )

  def jobParameter = new JobParameterDefinition('MY_LABS')
  jobParameter.createValue('Thanks GOOD');
  println currentBuild.projectName) 
  def currentJob = Jenkins.getInstance().getItem(currentBuild.projectName)
  currentJob.addProperty(jobParameter);

  stage('test') {
    echo("Hello, it is my firts multi branch pipeline. ${env.FOO}")
  }
}

return this
