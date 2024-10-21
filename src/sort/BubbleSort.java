package sort;

import utils.SortUtils;

/**
 * <h3> 버블 소트의 동작 원리 </h3>
 * <p>
 * 1. 인접한 요소 비교: 배열의 처음부터 끝까지 반복하면서, 인접한 두 요소를 비교합니다. <br/>
 * 2. 교환: 만약 첫 번째 요소가 두 번째 요소보다 크면 두 요소를 교환(swap)합니다. <br/>
 * 3. 반복: 배열을 끝까지 순회한 후, 가장 큰 요소가 마지막에 위치하게 됩니다. 이 과정을 배열이 정렬될 때까지 반복합니다. <br/>
 * 4. 정렬 완료: 배열의 모든 요소가 정렬되면 알고리즘이 종료됩니다.
 * <p>
 * <h3> 버블 소트의 특징 </h3>
 * <p>
 * 시간 복잡도: 최악의 경우 O(n²), 최선의 경우 O(n) (이미 정렬된 배열) <br/>
 * 안정성: 안정 정렬(stable sort), 같은 값을 가진 요소의 상대적 순서를 유지함 <br/>
 * 적용 가능성: 소규모 데이터 정렬에 적합
 */
public class BubbleSort
{
    public <T extends Comparable<T>> void bubbleSort(T[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            // 가장 큰 수는 맨 뒤에 정렬
            // 이미 정렬된 부분을 비교하지 않도록 i의 크기 만큼 빼줌
            for (int j = 0; j < arr.length - 1 - i; j++)
            {
                if (arr[j].compareTo(arr[j + 1]) > 0)
                {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 교환 메서드
     *
     * @param arr    원본 배열
     * @param index1 교환할 인덱스
     * @param index2 교환할 인덱스
     * @param <T>
     */
    private <T> void swap(T[] arr, int index1, int index2)
    {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public <T extends Comparable<T>> void checkRunTime(T[] array)
    {
        SortUtils.printArray(array, "정렬 전");

        long startTime = System.currentTimeMillis(); // 정렬 전 시간 측정 시작

        bubbleSort(array);

        long endTime = System.currentTimeMillis();   // 정렬 후 시간 측정 종료

        long duration = endTime - startTime; // 실행 시간 계산 (밀리초 단위)

        SortUtils.printArray(array, "정렬 후");

        // 결과 출력
        System.out.println("정렬 실행 시간: " + duration + " 밀리초");
    }

    public static void main(String[] args)
    {
        System.out.println("Bubble Sort Start!!");

        BubbleSort bubbleSort = new BubbleSort();

        // 실험 대상 설정
        System.out.println("Random Array Bubble Sort");
        Integer[] randomArray = SortUtils.getRandomArray();
        bubbleSort.checkRunTime(randomArray);

        System.out.println();

        System.out.println("Sorted Array Bubble Sort");
        Integer[] sortedArray = SortUtils.getSortedArray();
        bubbleSort.checkRunTime(sortedArray);

        bubbleSort.checkRunTime(SortUtils.engArr);
    }
}