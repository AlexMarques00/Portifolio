
/*
Sua classe também terá pelo menos dois construtores, e os métodos gets, sets, clone, imprimir e ler.

O método imprimir mostra os atributos do registro (ver cada linha da saída padrão) e 
o ler lê os atributos de um registro. 

Atenção para o arquivo de entrada, pois em alguns registros faltam valores 
e esse foi substituído pelo valor 0 (zero) ou vazio.

A entrada padrão é composta por várias linhas e cada uma contém uma string 
indicando o id do Personagem a ser lido. A última linha da entrada contém a palavra FIM. 

A saída padrão também contém várias linhas, uma para cada registro contido em uma linha da entrada padrão.
*/
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    static public Personagem[] characters = new Personagem[404];
    static RandomAccessFile Arq;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        Arq = new RandomAccessFile("/tmp/characters.csv", "r");
        Arq.readLine();
        String buffer = "";
        String atributos[];
        String altNames[];
        for (int i = 0; i < 404; i++) {
            buffer = Arq.readLine();
            atributos = buffer.split(";");
            buffer = atributos[2].replace("]", "").replace("[", "").replace("'", "");
            altNames = buffer.split(", ");
            characters[i] = new Personagem(atributos, altNames);
        }
        String input = sc.nextLine();
        while(input.compareTo("FIM") != 0){
            for (Personagem g : characters) {
                if(g.getId().compareTo(input) == 0){
                    System.out.println(g.printThis());
                    break;
                }
            }
            input = sc.nextLine();
        }
    }
}

class Personagem implements Cloneable {
    private String id;
    private String name;
    private String[] alternate_names;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private Boolean hogwartsStaff;
    private Boolean hogwartsStudent;
    private String actorName;
    private Boolean alive;
    private String dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private Boolean wizard;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAlternate_names() {
        return alternate_names;
    }

    public void setAlternate_names(String[] alternate_names) {
        if (alternate_names[0].compareTo("") == 0) {
            alternate_names[0] = "";
        }
        this.alternate_names = alternate_names;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getAncestry() {
        return ancestry;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getPatronus() {
        return patronus;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public Boolean getHogwartsStaff() {
        return hogwartsStaff;
    }

    public void setHogwartsStaff(Boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public Boolean getHogwartsStudent() {
        return hogwartsStudent;
    }

    public void setHogwartsStudent(Boolean hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public Boolean getWizard() {
        return wizard;
    }

    public void setWizard(Boolean wizard) {
        this.wizard = wizard;
    }

    Personagem(String atributos[], String altNames[]) {
        setId(atributos[0]);
        setName(atributos[1]);
        setAlternate_names(altNames);
        setHouse(atributos[3]);
        setAncestry(atributos[4]);
        setSpecies(atributos[5]);
        setPatronus(atributos[6]);
        setHogwartsStaff(getBoolean(atributos[7]));
        setHogwartsStudent(getBoolean(atributos[8]));
        setActorName(atributos[9]);
        setAlive(getBoolean(atributos[10]));
        //nn printa o alternate_actors
        setDateOfBirth(atributos[12]);
        setYearOfBirth(Integer.parseInt(atributos[13]));
        setEyeColour(atributos[14]);
        setGender(atributos[15]);
        setHairColour(atributos[16]);
        setWizard(getBoolean(atributos[17]));
    }

    public String printThis() {
        String output = "[" + id + " ## " + name + " ## ";
        String alternateNames = "{" + alternate_names[0];
        for (int b = 1; b < alternate_names.length && alternate_names[b].compareTo("") != 0; b++) {
            alternateNames = alternateNames + ", " + alternate_names[b];
        }
        alternateNames = alternateNames + "}";
        output = output + alternateNames + " ## " + house + " ## " + ancestry + " ## " + species +
                " ## " + patronus + " ## " + hogwartsStaff + " ## " + hogwartsStudent + " ## " + actorName +
                " ## " + alive + " ## " + dateOfBirth + " ## " + yearOfBirth + " ## " + eyeColour + " ## " +
                gender + " ## " + hairColour + " ## " + wizard + "]";
        return output;
    }

    public static Boolean getBoolean(String fakeBool) {
        if (fakeBool.compareTo("VERDADEIRO") == 0) {
            return false; //ta errado
        }
        return false;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}