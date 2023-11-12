package interface_adapter.enterMedicine;

import java.util.ArrayList;
import interface_adapter.TableState;
import interface_adapter.TableViewModel;
import interface_adapter.checklistChecked.ChecklistViewModel;
import use_case.enterMedicine.EnterOutputData;
import view.ViewManager;

public class EnterPresenter {

    private EnterViewModel enterViewModel;
    private ChecklistViewModel checklistViewModel;
    private TableViewModel tableViewModel;

    public EnterPresenter(EnterViewModel enterViewModel, ChecklistViewModel
            checklistViewModel, TableViewModel tableViewModel){
        this.enterViewModel = enterViewModel;
        this.checklistViewModel = checklistViewModel;
        this.tableViewModel = tableViewModel;
    }

    public void prepareSuccessView(EnterOutputData entry){

        EnterState enterState = enterViewModel.getState();
        TableState tableState = tableViewModel.getState();
        String[] tableData = new String[]{entry.toString()};
        tableState.addData(tableData);

        this.enterViewModel.setState(enterState);
        enterViewModel.firePropertyChanged();
        this.tableViewModel.setState(tableState);
        tableViewModel.firePropertyChanged();

    }

    public void updateChecklistState(EnterOutputData entry){}

    public void prepareFailView(String error){
        EnterState enterState = enterViewModel.getState();
        enterState.setEnterError(error);
        enterViewModel.firePropertyChanged();
    }
}
