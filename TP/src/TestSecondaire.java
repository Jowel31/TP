
//Vous allez devoir implementer Savane.getSavane() et Population.getIndividus()
public class TestSecondaire {
    public static void main(String[] args){
        /*
        if(true){
            System.out.println("�chec du test : ");
            nT++;
        }
        totalTest++;
        */
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Fichier Animal/Lion/Antilope sauf manger() et accoucher(). Il n'y aura pas de test cach� pour cette partie. \n");
        int totalTest=0;
        int nT=0;
        //0.0
        //La fonction vieillir doit augmenter la masse de l'animal en fonction de son facteur de croissance et 
        Animal test = new Lion(1.1);
        test.vieillir();
        if((test.getAge()!=1 || test.getMasse() != 11 || !test.estVivant())){
            System.out.println("�chec du test 0.0 : L:Animal.vieillir() 1 ans");
            nT++;
        }
        totalTest++;

        //0.1
        for(int i =test.getAge(); i < test.getAgeMax();i++){
            test.vieillir();
        }
        if(test.getAge()!=50 || test.getMasse() != (Math.pow(1.1,(50))*10) || !test.estVivant()){
            System.out.println("�chec du test 0.1 : L:Animal.vieillir() 50 ans");
            nT++;
        }
        totalTest++;

        //0.2
        test.vieillir();
        if(test.getAge()!=51 || test.getMasse() == (Math.pow(1.1,(test.getAge()))*10) || test.estVivant()){
            System.out.println("�chec du test 0.2 : L:Animal.vieillir() too Old");
            nT++;
        }
        totalTest++;

        //Antiloppe
        //0.3
        test = new Antilope(1.1);
        test.vieillir();
        if((test.getAge()!=1 || test.getMasse() != 11 || !test.estVivant())){
            System.out.println("�chec du test 0.3 : A:Animal.vieillir() 1 ans");
            nT++;
        }
        totalTest++;

        //0.4
        for(int i =test.getAge(); i < test.getAgeMax();i++){
            test.vieillir();
        }
        if(test.getAge()!=15 || Math.round(test.getMasse()) != Math.round((Math.pow(1.1,(test.getAge()))*10)) || !test.estVivant()){
            
            System.out.println("�chec du test 0.4 : A:Animal.vieillir() 15 ans");
            nT++;
        }
        totalTest++;

        //0.5
        test.vieillir();
        if(test.getAge()!=16 || test.estVivant()){
            System.out.println("�chec du test 0.5 : A:Animal.vieillir() too Old");
            nT++;
        }
        totalTest++;

        //0.6
        //mourrir, getMasse, setMasse, getAgeMax, estVivant, mourir, getAge, setAge
        test = new Antilope(1.1);
        test.setMasse(18);
        test.setAge(23);
        test.setProie(true);
        Boolean t1 = test.estVivant();
        test.mourir();
        if(test.getMasse() != 18 || test.getAge() !=23 || test.getAgeMax() != 15 || test.estVivant() || !t1 || !test.estProie() || !(test.getAgeMature() == 2)){
            System.out.println("�chec du test 0.6 : mourrir, getMasse, setMasse, getAgeMax, estVivant, mourir, getAge, setAge,setProie, estProie, getAgeMature");
            nT++;
        }
        totalTest++;

        //0.7
        //Maturite
        test = new Antilope(1.1);
        t1=test.estMature();
        test.vieillir();
        test.vieillir();
        test.vieillir();
        
        if(t1 || !test.estMature()){
            System.out.println("�chec du test 0.7 : estMature");
            nT++;
        }
        totalTest++;

        System.out.println("Reussi : " +(totalTest-nT));
        System.out.println("Rate : " +(nT));
    



    //----------------------------------------------------------------------------------------------------------------------------------
    System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////");
    System.out.println("Test des 3 fonctions principales de Population: vieillir,chasser et reproduction");
    totalTest=0;
    nT=0;
    Savane testV = new Savane(8,1.1,500,1.1,1,20000,200000,3.0,true);  
    Population pop = testV.getSavane();
    
    //vieillir()
    t1 = pop.getIndividus().get(0).getAge()==0;
    boolean t2 = pop.getIndividus().get(0).getMasse()==10;
    pop.vieillir();
    
    if(!t1 || !t2 || pop.getIndividus().get(0).getAge() !=1 || pop.getIndividus().get(0).getMasse() != 11){
        print("Probl�me avec la fonction Population.vieillir");
        nT++;
    }
    totalTest++;
    


    //reproduire
    pop.vieillir();
    pop.vieillir();
    pop.reproduire();
    pop.vieillir();
    pop.vieillir();
    pop.vieillir();
    pop.reproduire(); System.out.println("preds : " + pop.getNombrePredateurs() + " - proies : " + pop.getNombreProies());
    if(pop.getNombrePredateurs()!=12 || pop.getNombreProies()!=1125){
        print("Probl�me avec la fonction Population.reproduire");
        nT++;
    }
    totalTest++;
    //chasser    

    testV = new Savane(8,1.1,500,1.1,1,20000,200000,3.0,true);  
    pop = testV.getSavane();
    pop.chasser();
    if(pop.getNombrePredateurs()!=8 || pop.getNombreProies()!=484){
        print("Probl�me avec la fonction Population.chasser");
        nT++;
    }
    totalTest++;

    testV = new Savane(80,1.1,500,1.1,1,20000,200000,3.0,true);  
    pop = testV.getSavane();
    pop.chasser();
    if(pop.getNombrePredateurs()!=50 || pop.getNombreProies()!=400){
        print("Probl�me avec la fonction Population.chasser");
        nT++;
    }
    totalTest++;

    System.out.println("Reussi : " +(totalTest-nT)*1.5);
    System.out.println("Rate : " +(nT)*1.5);
    }
    public static void print( String text){
        System.out.println(text);
    }
    public static void print( int text){
        System.out.println(text);
    }
    public static void print( double text){
        System.out.println(text);
    }
    public static void print( Boolean text){
        System.out.println(text);
    }
}
