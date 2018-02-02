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



  properties([
    pipelineTriggers(currentBuild.getJob().getTriggers())
    parameters (currentBuild.getJobActions(currentBuild.getJob()))
  ])

  stage('test') {
    echo("Hello, it is my firts multi branch pipeline. ${env.FOO}")
  }
}

return this
