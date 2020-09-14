package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menu_v1")
public class MenuV1 {
	@Id
	int id;

	String nombre;

	@JoinColumn(name = "padre_id", referencedColumnName = "id")
	@ManyToOne
	MenuV1 mMenuV1;

	String ruta;

	String icon;

	Date version;

	int lft;

	int rgt;

	@OneToMany(mappedBy = "mMenuV1")
	private Collection<MenuV1> menuV1 = new ArrayList<>();

	@OneToMany(mappedBy = "mMenuV1")
	private Collection<MenuRoles> menuRoles = new ArrayList<>();

	public MenuV1() {

	}

	public MenuV1(int id, String nombre, MenuV1 mMenuV1, String ruta, String icon, Date version, int lft, int rgt) {

		this.id = id;
		this.nombre = nombre;
		this.mMenuV1 = mMenuV1;
		this.ruta = ruta;
		this.icon = icon;
		this.version = version;
		this.lft = lft;
		this.rgt = rgt;
	}

	public Collection<MenuRoles> getMenuRoles() {
		return menuRoles;
	}

	public void setMenuRoles(Collection<MenuRoles> menuRoles) {
		this.menuRoles = menuRoles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public MenuV1 getmMenuV1() {
		return mMenuV1;
	}

	public void setmMenuV1(MenuV1 mMenuV1) {
		this.mMenuV1 = mMenuV1;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	public int getLft() {
		return lft;
	}

	public void setLft(int lft) {
		this.lft = lft;
	}

	public int getRgt() {
		return rgt;
	}

	public void setRgt(int rgt) {
		this.rgt = rgt;
	}

	public Collection<MenuV1> getMenuV1() {
		return menuV1;
	}

	public void setMenuV1(Collection<MenuV1> menuV1) {
		this.menuV1 = menuV1;
	}

	@Override
	public String toString() {
		return "MenuV1 [id=" + id + ", nombre=" + nombre + ", mMenuV1=" + mMenuV1 + ", ruta="
				+ ruta + ", icon=" + icon + ", version=" + version + ", lft=" + lft + ", rgt=" + rgt + "]";
	}

}
