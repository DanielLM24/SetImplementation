/**
 * @author Peter Bennett/Daniel Lara
 *
 */


import java.util.*;


class SetFactory <E>{
	public Set<E> getSet(String input){
		switch(input){
		case("HashSet"):
			return new HashSet<E>();
		case("LinkedHashSet"):
			return new LinkedHashSet<E>();
		case("TreeSet"):
			return new TreeSet<E>();
		}
		return null;
	}
}
