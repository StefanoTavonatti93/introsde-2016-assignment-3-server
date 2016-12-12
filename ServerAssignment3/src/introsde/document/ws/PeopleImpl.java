package introsde.document.ws;


import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import tavonatti.stefano.model.HealthProfile;
import tavonatti.stefano.model.Measure;
import tavonatti.stefano.model.Person;
import tavonatti.stefano.model.variants.MeasureHistory;
import tavonatti.stefano.model.variants.MeasureType;
import tavonatti.stefano.model.variants.MeasureTypeList;

//Service Implementation

@WebService(endpointInterface = "introsde.document.ws.People",
    serviceName="PeopleService")
public class PeopleImpl implements People {

    @Override
    public Person readPerson(int id) {
        System.out.println("---> Reading Person by id = "+id);
        Person p = Person.getPersonById(id);
        if (p!=null) {
            System.out.println("---> Found Person by id = "+id+" => "+p.getFirstname());
        } else {
            System.out.println("---> Didn't find any Person with  id = "+id);
        }
        return p;
    }

    @Override
    public tavonatti.stefano.model.People getPeople() {
    	tavonatti.stefano.model.People p=new tavonatti.stefano.model.People ();
    	p.setPerson(Person.getAll());
    	return p;
    }

    @Override
    public Person addPerson(Person person) {
        Person p=Person.savePerson(person);
        return p;
    }

    @Override
    public Person updatePerson(Person person) {
    	Person p2=Person.getPersonById(person.getIdPerson());
    	p2.setFirstname(person.getFirstname());
    	p2.setBirthdate(person.getBirthdate());
    	p2.setLastname(person.getLastname());
        p2=Person.updatePerson(p2);
        return p2;
    }

    @Override
    public int deletePerson(int id) {
        Person p = Person.getPersonById(id);
        if (p!=null) {
            Person.removePerson(p);
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public int updatePersonHP(int id, HealthProfile hp) {
    	/*HealthProfile ls = HealthProfile.getLifeStatusById(hp.());
        if (ls.getPerson().getIdPerson() == id) {
        	HealthProfile.updateLifeStatus(hp);
            return hp.getIdMeasure();
        } else {
            return -1;
        }*/
    	return 0;
    }

	@Override
	public MeasureHistory readPersonHistory(int id, String measureType) {
		MeasureHistory mh=new MeasureHistory();
		Person p=Person.getPersonById(id);
		
		if(p==null)
			return null;
		
		if(p.getHealthProfile()==null)
			return null;
		
		List<Measure> mt= p.getHealthProfile().getMeasureList();
		
		if(mt==null)
			return null;
		
		int size=mt.size();
		
		for(int i=0;i<mt.size();i++){
			if(!mt.get(i).getMeasureType().equals(measureType)){
				mt.remove(i);
				i--;
			}
			
		}
		
		mh.setMeasure(mt);
		
		return mh;
	}

	@Override
	public MeasureTypeList readMeasureTypes() {
		return new MeasureTypeList();
	}

	@Override
	public Measure readPersonMeasure(int id, String measureType, int mid) {
		Person p=Person.getPersonById(id);
		
		if(p==null)
			return null;
		Measure m=Measure.getMeasureById(mid);
		return m;
	}

	@Override
	public Person savePersonMeasure(int id, Measure m) {
		Person p=Person.getPersonById(id);
		
		if(p==null)
			return null;
		
		if(p.getHealthProfile()==null)
			p.setHealthProfile(new HealthProfile());
		
		if(p.getHealthProfile().getMeasureList()==null)
			p.getHealthProfile().setMeasureList(new ArrayList<Measure>());
		
		p.getHealthProfile().getMeasureList().add(m);
		
		return Person.updatePerson(p);
	}

	@Override
	public Measure updatePersonMeasure(int id, Measure measureToUpdate) {
		Person p=Person.getPersonById(id);
		
		if(p==null)
			return null;
		
		return Measure.updateMeasure(measureToUpdate);
	}

}