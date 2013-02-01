package br.ufes.inf.lprm.scene;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;

import br.ufes.inf.lprm.scene.base.SituationHelper;
import br.ufes.inf.lprm.scene.base.SituationProfileManager;

public class SituationKnowledgeBaseFactory {
	
    public static KnowledgeBase newKnowledgeBase(KnowledgeBuilder kbuilder) throws Exception {
    	SituationHelper.refactorSaliences(kbuilder);
    	SituationProfileManager spm = SituationProfileManager.getInstance();
    	spm.BuildProfileFromPackages(kbuilder.getKnowledgePackages());
    	KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
    	kbase.addKnowledgePackages(kbuilder.getKnowledgePackages()); 
    	return kbase;
    }	

}