module es.ieslosmontecillos.innerclass {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.innerclass to javafx.fxml;
    exports es.ieslosmontecillos.innerclass;
}