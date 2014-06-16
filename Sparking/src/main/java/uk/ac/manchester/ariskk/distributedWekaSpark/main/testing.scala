package uk.ac.manchester.ariskk.distributedWekaSpark.main


import java.io.BufferedReader
import java.io.FileReader
import weka.core.Instances
import weka.associations.Apriori
import java.util.HashSet
import weka.associations.AssociationRule
import weka.associations.FPGrowth
import uk.ac.manchester.ariskk.distributedWekaSpark.associationRules.UpdatableRule
import scala.collection.mutable.HashMap
import weka.core.converters.CSVLoader
import weka.core.converters.ConverterUtils.DataSource
import scala.util.matching.Regex
import weka.clusterers.Canopy

object testing {

  def main(args: Array[String]): Unit = {

    val hashi=new HashMap[String,Int]()
    hashi+=("add" -> 5)
    hashi+=("dad" -> 7)
    println(hashi("add")+" "+ hashi("dad"))
    
    
    val source = new BufferedReader( new FileReader("/home/weka/Documents/weka-3-7-10/data/supermarket.arff"))
   
    val inst=new Instances(source) 
    
    val asl=new FPGrowth
    asl.setLowerBoundMinSupport(0.1)
    asl.buildAssociations(inst)
   // val asl2=new FPGrowth
   // asl2.setLowerBoundMinSupport(0.1)
   // asl2.buildAssociations(inst)
    val ruless=asl.getAssociationRules()
    val rules=ruless.getRules()
    //val ruless2=asl2.getAssociationRules()
   // val rules2=ruless2.getRules()
    
     println(asl)
     val rul=new UpdatableRule(rules.get(0))
//      println(rul.getPremiseString )
//      println(rul.getNumberOfItems)
      
      println(rules.get(0))
      println(rules.get(0).getConsequenceSupport()+" "+rules.get(0).getPremiseSupport()+" "+rules.get(0).getTotalSupport()+" "+rules.get(0).getTotalTransactions())
      println(rul.getConsequenceSupport+" "+rul.getPremiseSupport+" "+rul.getSupportCount+" "+rul.getTransactions)
      rul.addConsequenceSupport(rules.get(0).getConsequenceSupport())
      rul.addPremiseSupport(rules.get(0).getPremiseSupport())
      rul.addTransactions(10)
      rul.addSupportCount(10)
      println(rul.getConsequenceSupport+" "+rul.getPremiseSupport+" "+rul.getSupportCount+" "+rul.getTransactions)
      exit(0)

      
//     
//    val hashmap=new HashMap[String,UpdatableRule]
//    for(x<- 0 to rules.size()-1){hashmap.put(rules.get(x).getPremise()+" "+rules.get(x).getConsequence(),new UpdatableRule(rules.get(x)))}
//    
//    if(hashmap.contains(rules2.get(1).getPremise()+" "+rules2.get(1).getConsequence())){
//      //support update
//    println(hashmap.get(rules2.get(1).getPremise()+" "+rules2.get(1)))
//    
//    val nrule=hashmap(rules2.get(1).getPremise()+" "+rules2.get(1).getConsequence())
//    hashmap.remove(rules2.get(1).getPremise()+" "+rules2.get(1).getConsequence())
//    nrule.setSupportCount(rules2.get(1).getTotalSupport()+nrule.getSupportCount)
//    nrule.addConsequenceSupport(rules2.get(1).getConsequenceSupport())
//    nrule.addPremiseSupport(rules2.get(1).getPremiseSupport())
//    nrule.addTransactions(rules2.get(1).getTotalTransactions())
//    hashmap.put(nrule.getRule,nrule)
//    println(hashmap(rules2.get(1).getPremise()+" "+rules2.get(1).getConsequence()).getSupportCount)
//    
//    
//    }
//    val some=hashmap(rules2.get(1).getPremise()+" "+rules2.get(1).getConsequence())
//    println(some.getRuleString)
//    
//    
//    val ll=rules2.get(1).getMetricValuesForRule()
//    
//    val kk=rules2.get(1).getMetricNamesForRule()
   // for(x <-0 to ll.length-1){println(kk(x)+" "+ll(x))}
    println(rules.get(0).toString)
   // println(rules.get(0))
    println(rules.get(0).getConsequence()+"  "+rules.get(0).getConsequenceSupport())
    println(rules.get(0).getPremise()+"  "+rules.get(0).getPremiseSupport())
    println(rules.get(0).getTotalTransactions())
    println(rules.get(0).getTotalSupport())
   
  
  }

}