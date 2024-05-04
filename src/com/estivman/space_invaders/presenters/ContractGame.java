package com.estivman.space_invaders.presenters;

public interface ContractGame {

    public interface Model {
        public void setPresenter(Presenter presenter);
        public void setGamePanelSize(int width, int height);
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

    }
}
