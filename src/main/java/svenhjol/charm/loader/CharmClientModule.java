package svenhjol.charm.loader;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class CharmClientModule implements ICharmModule {
    private CharmCommonModule parentModule;
    private int priority = 0;
    private boolean enabledInConfig = true;
    private boolean enabledByDefault = true;
    private boolean alwaysEnabled = false;
    private final List<Predicate<ICharmModule>> dependencies = new ArrayList<>();

    @Override
    public String getModId() {
        return getParentModule().getModId();
    }

    @Override
    public void setModId(String modId) {
        // no op
    }

    @Override
    public List<Predicate<ICharmModule>> getDependencies() {
        return dependencies;
    }

    @Override
    public void addDependencyCheck(Predicate<ICharmModule> test) {
        dependencies.add(test);
    }

    @Override
    public boolean isEnabled() {
        return getParentModule().isEnabled();
    }

    @Override
    public boolean isEnabledInConfig() {
        return enabledInConfig;
    }

    @Override
    public boolean isEnabledByDefault() {
        return enabledByDefault;
    }

    @Override
    public boolean isAlwaysEnabled() {
        return alwaysEnabled;
    }

    public void setAlwaysEnabled(boolean flag) {
        this.alwaysEnabled = flag;
    }

    public void setEnabledByDefault(boolean flag) {
        this.enabledByDefault = flag;
    }

    @Override
    public void setEnabledInConfig(boolean flag) {
        this.enabledInConfig = flag;
    }

    @Override
    public void setEnabled(boolean flag) {
        // no op
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public CharmCommonModule getParentModule() {
        return parentModule;
    }

    public void setParentModule(CharmCommonModule module) {
        this.parentModule = module;
    }
}
