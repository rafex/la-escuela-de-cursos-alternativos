package mx.rafex.tutum.school.webapp.viewModel;

import java.util.List;

import org.zkoss.zk.ui.annotation.Command;
import org.zkoss.zul.ListModelList;

import mx.rafex.tutum.school.webapp.tmp.Car;
import mx.rafex.tutum.school.webapp.tmp.CarService;
import mx.rafex.tutum.school.webapp.tmp.CarServiceImpl;

/**
 * Suggest using ZK {@link org.zkoss.zul.ListModel} implementation as a
 * component's model.
 */
public class SearchViewModel {

    private String keyword;
    private List<Car> carList = new ListModelList<Car>();
    private Car selectedCar;

    private CarService carService = new CarServiceImpl(); // this could be any
                                                          // of your service
                                                          // class

    @Command
    public void search() {
        carList.clear();
        carList.addAll(carService.search(keyword));
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

}
