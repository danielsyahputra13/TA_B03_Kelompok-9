package apap.tugas.siretail.service;

import apap.tugas.siretail.model.CabangModel;
import apap.tugas.siretail.model.ItemCabangModel;
import apap.tugas.siretail.rest.PostItemDetail;

import java.util.List;

public interface ItemCabangService {
    ItemCabangModel getItemByIdItem(String idItem);
    List<ItemCabangModel> getListItem();
    void deleteItem(ItemCabangModel item);
    List<ItemCabangModel> getListItemInCabang(CabangModel cabangModel);
}
