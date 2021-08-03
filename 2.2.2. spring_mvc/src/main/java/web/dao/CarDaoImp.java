package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class CarDaoImp implements CarDao {
    private final List<Car> carList;

    public CarDaoImp() {
        carList = new ArrayList<>();
        carList.add(new Car(1, "ВАЗ", "Priora"));
        carList.add(new Car(2, "VAZ", "Granta"));
        carList.add(new Car(3, "VAZ", "Niva"));
        carList.add(new Car(4, "VAZ", "Shevrole"));
        carList.add(new Car(5, "VAZ", "Mustang"));

    }

    @Override
    public List<Car> getListCar(Integer count) {
        List<Car> list = this.carList;
        if (count != null) {
          //  int co = Integer.parseInt(count);
            if (count > 1 && count < 5) {
                list = carList.stream().limit(count).collect(Collectors.toList());
            }

        }return list;
    }
}
