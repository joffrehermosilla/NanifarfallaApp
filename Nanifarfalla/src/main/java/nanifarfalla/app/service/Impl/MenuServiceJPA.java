package nanifarfalla.app.service.Impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.SetMultimap;

import nanifarfalla.app.model.MenuV1;
import nanifarfalla.app.repository.MenuV1Repository;
import nanifarfalla.app.service.IMenuService;
import nanifarfalla.app.util.Arbol;
import nanifarfalla.app.util.ArbolCadenas;

@Service
public class MenuServiceJPA implements IMenuService {

	ArbolCadenas arbolcadenas;

	Arbol arbolDato;

	@Autowired
	private MenuV1Repository menuV1Repository;

	@Override
	public void inserta(MenuV1 menuv1) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		menuv1.setVersion(timestamp);
		HashMap<Integer, List<MenuV1>> hashMap = new HashMap<Integer, List<MenuV1>>();
		if (!hashMap.containsKey(menuv1.getId())) {
			List<MenuV1> list = new ArrayList<MenuV1>();
			list.add(menuv1);

			hashMap.put(menuv1.getId(), list);
		} else {
			hashMap.get(menuv1.getId()).add(menuv1);
		}

		/*
		 * if you want all the student with particular location details then you can use
		 * this:
		 * 
		 * hashMap.get(locationId);
		 */
		menuV1Repository.save(menuv1);
	}

	@Override
	public List<MenuV1> buscarTodas() {
		// TODO Auto-generated method stub
		return menuV1Repository.findAll();
	}

	@Override
	public void guardar(MenuV1 menuv1) {
		// TODO Auto-generated method stub
		menuV1Repository.save(menuv1);
	}

	@Override
	public MenuV1 buscarporId(int idMenuV1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChilds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void loadChilds() {
		List<MenuV1> menulista = menuV1Repository.findAll();
		arbolcadenas = new ArbolCadenas();
		for (MenuV1 menus : menulista) {
			arbolcadenas.insertar(menus.getNombre());
		}

		System.out.println("Recorriendo inorden:");
		arbolcadenas.inorden();
		System.out.println("Recorriendo postorden:");
		arbolcadenas.postorden();
		System.out.println("Recorriendo preorden:");
		arbolcadenas.preorden();
		System.out.println(arbolcadenas.existe("Null")); //

	}

	@Override
	public void arbolHijos() {
		List<MenuV1> menulista = menuV1Repository.findAll();
		arbolDato = new Arbol();
		for (MenuV1 menus : menulista) {
			arbolDato.insertar(menus.getRgt() + menus.getLft());
		}

		System.out.println("Recorriendo inorden:");
		arbolDato.inorden();
		System.out.println("Recorriendo postorden:");
		arbolDato.postorden();
		System.out.println("Recorriendo preorden:");
		arbolDato.preorden();
		System.out.println(arbolDato.existe(2)); //
	}

	@Override
	public void JpaHijos() {

		MenuV1 menux = new MenuV1();
		List<MenuV1> menulista = menuV1Repository.findAll(); // Simple Grouping by a Single Column
		Map<String, List<MenuV1>> menusByNombre = menulista.stream().collect(Collectors.groupingBy(MenuV1::getNombre));
		// Grouping by With a Complex Map Key Type
		Map<MenuV1, List<MenuV1>> postsPerPadreAndhijos = menulista.stream()
				.collect(Collectors.groupingBy(post -> new MenuV1(post.getId(), post.getNombre(), post.getmMenuV1(),
						post.getRuta(), post.getIcon(), post.getVersion(), post.getLft(), post.getRgt())));

		// Modifying the Returned Map Value Type no funciona

		// Map<String, Set<MenuV1>> postsPerNombre =
		// menulista.stream().collect(groupingBy(MenuV1::getNombre, toSet()));

		// Grouping by Multiple Fields

		Map<String, Map<String, List<MenuV1>>> mapa = menulista.stream()
				.collect(Collectors.groupingBy(MenuV1::getNombre, Collectors.groupingBy(MenuV1::getNombre)));

		Map<String, Map<Integer, List<MenuV1>>> map = menulista.stream()
				.collect(Collectors.groupingBy(MenuV1::getNombre, Collectors.groupingBy(MenuV1::getId)));

		// Getting the Average from Grouped Results Map<BlogPostType, Double>
		// averageLikesPerType = posts.stream().collect(groupingBy(BlogPost::getType,
		// averagingInt(BlogPost::getLikes)));

		// Getting the Sum from Grouped Results Map<MenuV1, Integer> likesPerType =
		// menulista.stream().collect(groupingBy(MenuV1::getType,
		// Collectors.summingInt(MenuV1::getLikes)));

		// Getting the Maximum or Minimum from Grouped Result
		// Map<Integer, Optional<MenuV1>> maxLikesPerPostType = menulista.stream()
		// .collect(Collectors.groupingBy(MenuV1::getNombre,
		// maxBy(Collectors.summingInt(MenuV1::getLft))));

		// Getting a Summary for an Attribute of Grouped Results
		// Map<BlogPostType, IntSummaryStatistics> likeStatisticsPerType =
		// posts.stream().collect(groupingBy(BlogPost::getType,
		// summarizingInt(BlogPost::getLikes)));

		// Concurrent Grouping by Collector

		ConcurrentMap<String, List<MenuV1>> Concurrentenombre = menulista.parallelStream()
				.collect(Collectors.groupingByConcurrent(MenuV1::getNombre));

		SetMultimap<String, MenuV1> MenuxNombrerMap = LinkedHashMultimap.create();
		// .. other stuff, then whenever you need it:

		MenuxNombrerMap.put(menux.getNombre(), menux);

	}

	@Override
	public MenuV1 buscarPorId(int idMenuV1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<MenuV1>> menusByNombre() {
		List<MenuV1> menulista = menuV1Repository.findAll();
		Map<String, List<MenuV1>> menusByNombre = menulista.stream().collect(Collectors.groupingBy(MenuV1::getNombre));
		return menusByNombre;
	}

	@Override
	public Map<MenuV1, List<MenuV1>> postsPerPadreAndhijos() {
		List<MenuV1> menulista = menuV1Repository.findAll();
		Map<MenuV1, List<MenuV1>> postsPerPadreAndhijos = menulista.stream()
				.collect(Collectors.groupingBy(post -> new MenuV1(post.getId(), post.getNombre(), post.getmMenuV1(),
						post.getRuta(), post.getIcon(), post.getVersion(), post.getLft(), post.getRgt())));
		return postsPerPadreAndhijos;
	}

	@Override
	public Map<String, List<MenuV1>> menusxNombre() {
		List<MenuV1> menulista = menuV1Repository.findAll();
		Map<String, List<MenuV1>> menusuByNombre = new HashMap<String, List<MenuV1>>();
		for (MenuV1 menus : menulista) {
			if (menusuByNombre.containsKey(menus.getNombre())) {
				// Add to existing list
				menusuByNombre.get(menus.getNombre()).add(menus);

			} else {
				// Create new list
				List<MenuV1> menux = new ArrayList<MenuV1>(1);
				menux.add(menus);
				menusuByNombre.put(menus.getNombre(), menux);
			}
		}

		return menusuByNombre;
	}

	@Override
	public Map<String, List<MenuV1>> menusporNombre() {
		List<MenuV1> menulista = menuV1Repository.findAll();

		Map<String, List<MenuV1>> menusByNombre = new HashMap<>();

		for (MenuV1 menux : menulista) {
			menusByNombre.computeIfAbsent(menux.getNombre(), k -> new ArrayList<>()).add(menux);
		}

		return menusByNombre;
	}

	@Override
	public Map<String, Map<String, List<MenuV1>>> mapa() {
		List<MenuV1> menulista = menuV1Repository.findAll();
		Map<String, Map<String, List<MenuV1>>> mapa = menulista.stream()
				.collect(Collectors.groupingBy(MenuV1::getNombre, Collectors.groupingBy(MenuV1::getNombre)));

		return mapa;
	}

	@Override
	public Map<String, Map<Integer, List<MenuV1>>> map() {
		List<MenuV1> menulista = menuV1Repository.findAll();
		Map<String, Map<Integer, List<MenuV1>>> map = menulista.stream()
				.collect(Collectors.groupingBy(MenuV1::getNombre, Collectors.groupingBy(MenuV1::getId)));

		return map;
	}

	@Override
	public ConcurrentMap<String, List<MenuV1>> Concurrentenombre() {
		List<MenuV1> menulista = menuV1Repository.findAll();

		ConcurrentMap<String, List<MenuV1>> Concurrentenombre = menulista.parallelStream()
				.collect(Collectors.groupingByConcurrent(MenuV1::getNombre));

		return Concurrentenombre;
	}

	@Override
	public SetMultimap<String, MenuV1> MenuxNombrerMap() {

		List<MenuV1> menulista = menuV1Repository.findAll();
		SetMultimap<String, MenuV1> MenuxNombrerMap = LinkedHashMultimap.create();
		// .. other stuff, then whenever you need it:

		for (MenuV1 menux : menulista) {
			MenuxNombrerMap.put(menux.getNombre(), menux);
		}

		return MenuxNombrerMap;
	}

	@Override
	public int lascode() {
		// TODO Auto-generated method stub
		return menuV1Repository.lastcode();
	}

	@Override
	public void updatemenu(String name, int id) {
		// TODO Auto-generated method stub
		menuV1Repository.updatemenu(name, id);
	}

	@Override
	public void elimina(MenuV1 menuv1) {
		// TODO Auto-generated method stub
		menuV1Repository.delete(menuv1);
	}

	@Override
	public MenuV1 get(int menuv1Id) {
		// TODO Auto-generated method stub
		return menuV1Repository.getOne(menuv1Id);
	}

	@Override
	public List<MenuV1> list() {
		// TODO Auto-generated method stub
		return menuV1Repository.findAll();
	}

	@Override
	public Page<MenuV1> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return menuV1Repository.findAll(page);
	}

	@Override
	public void eliminar(int menuv1Id) {
		// TODO Auto-generated method stub

		menuV1Repository.deleteById(menuv1Id);

	}

	@Override
	public Optional<MenuV1> obuscarporId(int id) {
		// TODO Auto-generated method stub
		return menuV1Repository.findById(id);
	}

}
