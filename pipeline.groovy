#!/usr/bin/env groovy
import hudson.model.StringParameterDefinition
import hudson.model.ParametersDefinitionProperty
import com.cloudbees.groovy.cps.NonCPS

@NonCPS
def execute() {
  def newParam = new StringParameterDefinition('foo', 'var', 'mi variable')
  def newArrList = []
  newArrList.add(newParam)
  def newParamDef = new ParametersDefinitionProperty(newArrList)

  // def job = Jenkins.instance.getProjectName(currentBuild.getProjectName())
  echo("=======> el nombre es: ${currentBuild.getProjectName()}")
  currentBuild.addAction(newParamDef)


  stage('test') {
    echo('Hello, it is my firts multi branch pipeline.')
  }
}

return this
