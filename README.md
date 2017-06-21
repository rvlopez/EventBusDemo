# EventBusDemo
This is a simple demo using EventBus. EventBus is a publish/subscriber event bus optimized for Android and developed by Markus Junginger in [Greenrobot](https://github.com/greenrobot/EventBus).

EventBus in 3 steps
--------------------
1. Define events:

    ```java  
    public class GlobalBus {
        private static EventBus eventBus;

        public static EventBus getEventBus() {
            if (eventBus == null) {
                eventBus = EventBus.getDefault();
            }
            return eventBus;
        }
    }
    ```

2. Prepare subscribers:
    Declare and annotate your subscribing method, optionally specify a [thread mode](http://greenrobot.org/eventbus/documentation/delivery-threads-threadmode/):  

    ```java
    @Subscribe(sticky = true)
    public void onMessageEvent(EventMessageList event) { /* Do something */ }
    ```
    Register and unregister your subscriber. For example on Android, activities and fragments should usually register according to their life cycle:

    ```java
    @Override
    protected void onStart() {
        super.onStart();
        GlobalBus.getEventBus().register(this);
    }

    @Override
    protected void onStop() {
        GlobalBus.getEventBus().unregister(this);
        super.onStop();
    }
    ```

3. Post events:

    ```java
    GlobalBus.getEventBus().postSticky(new EventMessageList(messageList));
    ```
    

Read the full [getting started guide](http://greenrobot.org/eventbus/documentation/how-to-get-started/).



