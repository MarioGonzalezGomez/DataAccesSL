public class Facade {
    private static Facade instance;


    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }


    public void checkService() {
    }

    public void initDataBase() {
    }

    public void Proyectos() {
    }

    public void Programadores() {
    }

    public void Repositorios() {
    }

    public void Commits() {
    }

    public void Issues() {
    }
}
