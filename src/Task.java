
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task {
    static final String inputFile = "Activities.txt";
    static final Path inPath = Paths.get(inputFile);
    List<MonitoredData> monitoredDataList;

    public List<MonitoredData> task1() throws FileNotFoundException {
        try {
            return Files.lines(inPath).map(s -> s.split("		")).map(s -> {
                s[0] = s[0].replace(" ", "T");
                s[1] = s[1].replace(" ", "T");
                MonitoredData d = new MonitoredData(LocalDateTime.parse(s[0].replace(" ", "T")), LocalDateTime.parse(s[1]), s[2].trim());
                return d;
            })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int task2() {
        int nrDays = 0;
        nrDays = monitoredDataList.stream().collect(Collectors.mapping(MonitoredData::getS, Collectors.toSet())).size();
        return nrDays;

    }


    public Map<String, Integer> task3() {
        Map<String, Integer> count = monitoredDataList.stream().collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.collectingAndThen(Collectors.mapping(e -> {
            return e.getActivity();
        }, Collectors.counting()), Long::intValue)));
        return count;
    }

    public Map<String, Map<String, Integer>> task4() {
        Map<String, Map<String, Integer>> count = monitoredDataList.stream().collect(Collectors.groupingBy
                (MonitoredData::getS, Collectors.groupingBy(MonitoredData::getActivity, Collectors.collectingAndThen(Collectors.mapping(MonitoredData::getActivity, Collectors.counting()), Long::intValue))));
        return count;
    }

    public Map<String, Integer> task5() {
        Map<String, Integer> map = monitoredDataList.stream().collect(
                Collectors.groupingBy(MonitoredData::getActivity, Collectors.collectingAndThen(Collectors.mapping(MonitoredData::getTime, Collectors.summingInt(e -> e.intValue())), e -> e.intValue())
                )).entrySet().stream().collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
        return map;
    }

    public List<String> task6() {
        List<String> list = monitoredDataList.stream()
                .collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.toSet())).entrySet().stream().map(a -> {
                    int under = 0;
                    for (MonitoredData data : a.getValue()) {
                        if (data.getTime() < 5) under++;
                    }
                    if (under > a.getValue().size() * 90 / 100) return a.getKey();
                    return null;
                }).filter(e -> e != null).collect(Collectors.toList());
        return list;
    }
}

