package com.estivman.space_invaders.presenters;

import java.util.List;

import com.estivman.space_invaders.pojos.Martian;
import com.estivman.space_invaders.pojos.Shooter;

public interface ContractGame {

    public interface Model {
        public void setPresenter(Presenter presenter);
        public void setGamePanelSize(int width, int height);
        public List<Martian> getMartians();
        public void addNewMartian();
        public void initShooter(int width, int height);
        public void moveToRight();
        public void moveToLeft();
        public Shooter getShooter();
    }

    public interface View {
        public void setPresenter(Presenter presenter);
        public void run();
    }

    public interface Presenter {
        public void setModel(Model model);
        public void setView(View view);
        public void setGamePanelSize(int width, int height);
        public void run();

        public List<Martian> getMartians();
        public void initShooter(int width, int height);
        public void addNewMartian();   
        public void moveToRight();
        public void moveToLeft();   
        public Shooter getShooter();


    }
}
