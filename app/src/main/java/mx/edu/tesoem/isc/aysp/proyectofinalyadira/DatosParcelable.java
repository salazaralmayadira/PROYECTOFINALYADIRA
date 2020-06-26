package mx.edu.tesoem.isc.aysp.proyectofinalyadira;

import android.os.Parcel;
import android.os.Parcelable;

public class DatosParcelable implements Parcelable {
    String Matricula, Nombre, Correo, Calificacion;

    public DatosParcelable(String matricula, String nombre, String correo, String calificacion) {
        Matricula = matricula;
        Nombre = nombre;
        Correo = correo;
        Calificacion = calificacion;
    }

    protected DatosParcelable(Parcel in) {
        Matricula = in.readString();
        Nombre = in.readString();
        Correo = in.readString();
        Calificacion = in.readString();
    }

    public static final Creator<DatosParcelable> CREATOR = new Creator<DatosParcelable>() {
        @Override
        public DatosParcelable createFromParcel(Parcel in) {
            return new DatosParcelable(in);
        }

        @Override
        public DatosParcelable[] newArray(int size) {
            return new DatosParcelable[size];
        }
    };

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(String calificacion) {
        Calificacion = calificacion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Matricula);
        dest.writeString(Nombre);
        dest.writeString(Correo);
        dest.writeString(Calificacion);
    }
}
