package com.SACInstance;
import com.GSN.*;
import com.Planner.Impact;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class InstantiateSAC {

    private DocumentBuilderFactory documentFactory;
    private DocumentBuilder dBuilder;
    private Document document;
    private List<MainGoal> mainGoals;
    private List<ReqGoal> reqGoals;
    private List<ModuleGoal> moduleGoals;
    private List<OppGoal> oppGoals;
    private List<Strategy> strategies;
    private List<Solution> solutions;
    private List<Context> contexts;
    private List<InContextOf> inContextOfLinks;
    private List<SupportedBy> supportedByLinks;

    public InstantiateSAC() {}

    public InstantiateSAC(String name)
    {
        this.mainGoals = new ArrayList<MainGoal>();
        this.reqGoals = new ArrayList<ReqGoal>();
        this.moduleGoals = new ArrayList<ModuleGoal>();
        this.oppGoals = new ArrayList<OppGoal>();
        this.strategies = new ArrayList<Strategy>();
        this.solutions = new ArrayList<Solution>();
        this.contexts = new ArrayList<Context>();
        this.inContextOfLinks = new ArrayList<InContextOf>();
        this.supportedByLinks = new ArrayList<SupportedBy>();
        try {
            File fXmlFile = new File("./"+name);
            this.documentFactory = DocumentBuilderFactory.newInstance();
            this.dBuilder = documentFactory.newDocumentBuilder();
            this.document = dBuilder.parse(fXmlFile);
            document.getDocumentElement().normalize();

        }catch (Exception e) {
            System.out.println("Error in file loading");
            e.printStackTrace();
        }
    }


    public Document getDocument() {

        return document;
    }

    public void setMainGoals()
    {
        int temp = 0;

        Node nNode = null;
        NodeList MainGoalList = document.getElementsByTagName("MainGoal");
        for (temp = 0; temp < MainGoalList.getLength(); temp++) {
            nNode = MainGoalList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                this.mainGoals.add(new MainGoal(eElement.getAttribute("family").toString(),
                        eElement.getAttribute("number").toString(),
                        eElement.getAttribute("identifier").toString(),
                        eElement.getAttribute("implemented_by").toString(),
                        eElement.getAttribute("control_action").toString(),
                        eElement.getAttribute("baseline_allocation").toString(),
                        eElement.getAttribute("provision_set").toString(),
                        eElement.getAttribute("achievement_weight").toString()));
            }
        }

    }

    public List<MainGoal> getMainGoals() {
        return mainGoals;
    }

    public void setSubGoals()
    {
        int temp = 0;
        Node nNode = null;
        NodeList SubgoalList = document.getElementsByTagName("ReqGoal");
        for (temp = 0; temp < SubgoalList.getLength(); temp++) {
            nNode = SubgoalList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                this.reqGoals.add(new ReqGoal(eElement.getAttribute("identifier").toString(),
                        eElement.getAttribute("assessment_process").toString(),
                        eElement.getAttribute("functional_requirement").toString(),
                        eElement.getAttribute("achievement_weight").toString()));
            }
        }
    }

    public List<ReqGoal> getSubGoals() {
        return reqGoals;
    }

    public void setModuleGoals()
    {
        int temp = 0;
        Node nNode = null;
        NodeList ModulegoalList = document.getElementsByTagName("ModuleGoal");
        for (temp = 0; temp < ModulegoalList.getLength(); temp++) {
            nNode = ModulegoalList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                this.moduleGoals.add(new ModuleGoal(eElement.getAttribute("identifier").toString(),
                        eElement.getAttribute("assessment_process").toString(),
                        eElement.getAttribute("achievement_weight").toString()));
            }
        }
    }

    public List<ModuleGoal> getModuleGoals() {
        return moduleGoals;
    }

    public void setOppGoals()
    {
        int temp = 0;
        Node nNode = null;
        NodeList OppgoalList = document.getElementsByTagName("OpGoal");
        for (temp = 0; temp < OppgoalList.getLength(); temp++) {
            nNode = OppgoalList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                this.oppGoals.add(new OppGoal(eElement.getAttribute("identifier").toString(),
                        eElement.getAttribute("variable").toString(),
                        eElement.getAttribute("condition").toString(),
                        eElement.getAttribute("achievement_weight")));
            }
        }
    }

    public List<OppGoal> getOppGoals() {
        return oppGoals;
    }

    public void setStrategies()
    {
        int temp = 0;
        Node nNode = null;
        NodeList StrategyList = document.getElementsByTagName("Strategy");
        for (temp = 0; temp < StrategyList.getLength(); temp++) {
            nNode = StrategyList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                this.strategies.add(new Strategy(eElement.getAttribute("identifier").toString(),
                        eElement.getAttribute("assessment_Process").toString()));
            }
        }
    }

    public List<Strategy> getStrategies() {
        return strategies;
    }

    public void setContexts()
    {
        int temp = 0;
        Node nNode = null;
        NodeList ContextList = document.getElementsByTagName("Context");
        for (temp = 0; temp < ContextList.getLength(); temp++) {
            nNode = ContextList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                this.contexts.add(new Context(eElement.getAttribute("identifier").toString(),
                        eElement.getAttribute("tailoring").toString()));
            }
        }
    }

    public List<Context> getContexts() {
        return contexts;
    }

    public void setSolutions()
    {
        int temp = 0;
        Node nNode = null;
        NodeList SolutionList = document.getElementsByTagName("Solution");
        for (temp = 0; temp < SolutionList.getLength(); temp++) {
            nNode = SolutionList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                this.solutions.add(new Solution(eElement.getAttribute("identifier").toString(),
                        eElement.getAttribute("assessment").toString(),
                        new Impact(eElement.getAttribute("provision"),
                                eElement.getAttribute("cond"),
                                Double.valueOf(eElement.getAttribute("impactFactor")))));
            }
        }
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setInContextOfLinks()
    {
        int temp = 0;
        Node nNode = null;
        NodeList InContextOfLinks = document.getElementsByTagName("InContextOf");
        for (temp = 0; temp < InContextOfLinks.getLength(); temp++) {
            nNode = InContextOfLinks.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                this.inContextOfLinks.add( new InContextOf(
                        eElement.getAttribute("source").toString(),
                        eElement.getAttribute("destination").toString()));

            }
        }
    }

    public List<InContextOf> getInContextOfLinks() {
        return inContextOfLinks;
    }

    public void setSupportedByLinks()
    {

        int temp = 0;
        Node nNode = null;
        NodeList SupportedByLinks = document.getElementsByTagName("SupportedBy");
        for (temp = 0; temp < SupportedByLinks.getLength(); temp++) {
            nNode = SupportedByLinks.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                if(eElement.getAttribute("Requires").toString().equals("") ) {
                    this.supportedByLinks.add( new SupportedBy(eElement.getAttribute("source").toString(),
                            eElement.getAttribute("destination").toString()));
                }
                else
                {

                    this.supportedByLinks.add( new ProvidesRequires(eElement.getAttribute("source").toString(),
                            eElement.getAttribute("destination").toString(),
                            eElement.getAttribute("Requires").toString()));
                }

            }
        }
    }

    public List<SupportedBy> getSupportedByLinks() {
        return supportedByLinks;
    }

    public void loadXML()
    {
        this.setMainGoals();
        this.setSubGoals();
        this.setModuleGoals();
        this.setOppGoals();
        this.setContexts();
        this.setStrategies();
        this.setSolutions();
        this.setSupportedByLinks();
        this.setInContextOfLinks();
    }


    public void generateAssuranceCase (String fileName, InstantiateSAC assuranceCaseInstance)
    {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("GSN");
            document.appendChild(root);

            for (MainGoal g : assuranceCaseInstance.getMainGoals()) {
                Element goal = document.createElement("MainGoal");
                root.appendChild(goal);

                Attr family = document.createAttribute("family");
                family.setValue(((MainGoal) g).getFamily());
                goal.setAttributeNode(family);

                Attr number = document.createAttribute("number");
                number.setValue(((MainGoal) g).getNumber());
                goal.setAttributeNode(number);

                Attr identifier = document.createAttribute("identifier");
                identifier.setValue(((MainGoal) g).getIdentifier());
                goal.setAttributeNode(identifier);

                Attr implementedBy = document.createAttribute("implemented_by");
                implementedBy.setValue(((MainGoal) g).getImplementedBy());
                goal.setAttributeNode(implementedBy);

                Attr action = document.createAttribute("control_action");
                action.setValue(((MainGoal) g).getControlAction());
                goal.setAttributeNode(action);

                Attr baselineAllocation = document.createAttribute("baseline_allocation");
                baselineAllocation.setValue(((MainGoal) g).getBaselineAllocation());
                goal.setAttributeNode(baselineAllocation);

                Attr provisionSet = document.createAttribute("provision_set");
                provisionSet.setValue(((MainGoal) g).getProvisionSet());
                goal.setAttributeNode(provisionSet);


                Attr achievemnetweight = document.createAttribute("achievement_weight");
                achievemnetweight.setValue(((MainGoal) g).getAchievementWeight());
                goal.setAttributeNode(achievemnetweight);

                Attr Statement = document.createAttribute("statement");
                String stmt = "Goal: " + ((MainGoal) g).getFamily() + "-" + ((MainGoal) g).getNumber() + " " + g.getIdentifier() + " Main: " +
                        ((MainGoal) g).getImplementedBy() + " " + ((MainGoal) g).getControlAction() + "; Impact = " + ((MainGoal) g).getBaselineAllocation() +
                        ", Provides= [ " + ((MainGoal) g).getProvisionSet() + "]; aw = " + g.getAchievementWeight();
                Statement.setValue(stmt);
                goal.setAttributeNode(Statement);
            }

            for (ReqGoal g:assuranceCaseInstance.getSubGoals()) {
                Element goal = document.createElement("ReqGoal");
                root.appendChild(goal);

                Attr identifier = document.createAttribute("identifier");
                identifier.setValue(g.getIdentifier());
                goal.setAttributeNode(identifier);

                Attr assessmentProcess = document.createAttribute("assessment_process");
                assessmentProcess.setValue(((ReqGoal) g).getAssessmentProcess());
                goal.setAttributeNode(assessmentProcess);

                Attr funcReq = document.createAttribute("functional_requirement");
                funcReq.setValue(((ReqGoal) g).getFunctionalReq());
                goal.setAttributeNode(funcReq);

                Attr achievemnetweight = document.createAttribute("achievement_weight");
                achievemnetweight.setValue(g.getAchievementWeight());
                goal.setAttributeNode(achievemnetweight);

                Attr Statement = document.createAttribute("statement");
                String stmt = "Goal: " + g.getIdentifier() + ": " + ((ReqGoal) g).getAssessmentProcess() + " maintains " +
                        ((ReqGoal) g).getFunctionalReq() + "; aw = " + g.getAchievementWeight();
                Statement.setValue(stmt);
                goal.setAttributeNode(Statement);
            }

            for (ModuleGoal g: assuranceCaseInstance.getModuleGoals()) {
                Element goal = document.createElement("ModuleGoal");
                root.appendChild(goal);

                Attr identifier = document.createAttribute("identifier");
                identifier.setValue(g.getIdentifier());
                goal.setAttributeNode(identifier);

                Attr assessmentProcess = document.createAttribute("assessment_process");
                assessmentProcess.setValue(((ModuleGoal) g).getAssessmentProcess());
                goal.setAttributeNode(assessmentProcess);

                Attr achievemnetweight = document.createAttribute("achievement_weight");
                achievemnetweight.setValue(g.getAchievementWeight());
                goal.setAttributeNode(achievemnetweight);

                Attr Statement = document.createAttribute("statement");
                String stmt = "Module: " + g.getIdentifier() + " " + ": Argument over operational subgoal(s) of " +
                        ((ModuleGoal) g).getAssessmentProcess() + "; aw = " + g.getAchievementWeight();
                Statement.setValue(stmt);
                goal.setAttributeNode(Statement);


            }

            for(OppGoal g: assuranceCaseInstance.getOppGoals())
            {
                Element goal = document.createElement("OppGoal");
                root.appendChild(goal);

                Attr identifier = document.createAttribute("identifier");
                identifier.setValue(g.getIdentifier());
                goal.setAttributeNode(identifier);

                Attr variables = document.createAttribute("variable");
                variables.setValue(((OppGoal) g).getVariable());
                goal.setAttributeNode(variables);

                Attr con = document.createAttribute("condition");
                con.setValue(((OppGoal) g).getCondition());
                goal.setAttributeNode(con);

                Attr achievemnetweight = document.createAttribute("achievement_weight");
                achievemnetweight.setValue(g.getAchievementWeight());
                goal.setAttributeNode(achievemnetweight);

                Attr Statement = document.createAttribute("statement");
                String stmt = "Goal: " + g.getIdentifier() + ": Variables = " +
                        ((OppGoal) g).getVariable() + "; Condition = " + ((OppGoal) g).getCondition() + "; aw = " + g.getAchievementWeight();
                Statement.setValue(stmt);
                goal.setAttributeNode(Statement);

            }

            for (Context c:assuranceCaseInstance.getContexts()) {
                Element Context = document.createElement("Context");
                root.appendChild(Context);

                Attr id = document.createAttribute("identifier");
                id.setValue(c.getIdentifier());
                Context.setAttributeNode(id);

                Attr assignmentTailoring = document.createAttribute("tailoring");
                assignmentTailoring.setValue(c.getTailoring());
                Context.setAttributeNode(assignmentTailoring);

                Attr Statement = document.createAttribute("statement");
                String stmt = "Context: " + c.getIdentifier() + ": Assignment: " + c.getTailoring();
                Statement.setValue(stmt);
                Context.setAttributeNode(Statement);
            }

            for (Strategy c : assuranceCaseInstance.getStrategies()) {
                Element strategy = document.createElement("Strategy");
                root.appendChild(strategy);

                Attr identifier = document.createAttribute("identifier");
                identifier.setValue(c.getIdentifier());
                strategy.setAttributeNode(identifier);

                Attr assessmentProcess = document.createAttribute("assessment_Process");
                assessmentProcess.setValue(c.getAssessmentProcess());
                strategy.setAttributeNode(assessmentProcess);

                Attr Statement = document.createAttribute("statement");
                String stmt = "Strategy: " + c.getIdentifier()+": Argument over "+ c.getAssessmentProcess();
                Statement.setValue(stmt);
                strategy.setAttributeNode(Statement);

            }

            for (Solution c:assuranceCaseInstance.getSolutions()) {
                Element solution = document.createElement("Solution");
                root.appendChild(solution);

                Attr id = document.createAttribute("identifier");
                id.setValue(c.getIdentifier());
                solution.setAttributeNode(id);

                Attr assignmentTailoring = document.createAttribute("assessment");
                assignmentTailoring.setValue(c.getAssessment());
                solution.setAttributeNode(assignmentTailoring);

                Attr Statement = document.createAttribute("statement");
                String stmt = "Solution: " + c.getIdentifier() + ": " + c.getAssessment();
                Statement.setValue(stmt);
                solution.setAttributeNode(Statement);

            }

            for (SupportedBy c:assuranceCaseInstance.getSupportedByLinks()) {
                Element supportedBy = document.createElement("SupportedBy");
                root.appendChild(supportedBy);

                Attr source = document.createAttribute("source");
                source.setValue(c.getSource());
                supportedBy.setAttributeNode(source);

                Attr dest = document.createAttribute("destination");
                dest.setValue(c.getDestination());
                supportedBy.setAttributeNode(dest);

                if (c instanceof ProvidesRequires){


                    Attr req = document.createAttribute("Requires");
                    req.setValue(((ProvidesRequires) c).getProvisionSet());
                    supportedBy.setAttributeNode(req);
                }


            }

            for (InContextOf c: assuranceCaseInstance.getInContextOfLinks()) {
                Element inContextOf = document.createElement("InContextOf");
                root.appendChild(inContextOf);

                Attr source = document.createAttribute("source");
                source.setValue(c.getSource());
                inContextOf.setAttributeNode(source);

                Attr dest = document.createAttribute("destination");
                dest.setValue(c.getDestination());
                inContextOf.setAttributeNode(dest);
            }



            try {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource domSource = new DOMSource(document);
                StreamResult streamResult = new StreamResult(new File("./"+fileName+".xml"));

                transformer.transform(domSource, streamResult);

             //   System.out.println("Done creating XML File");
            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            }

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }
    }
}
